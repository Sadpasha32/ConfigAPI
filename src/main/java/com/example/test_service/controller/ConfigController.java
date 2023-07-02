package com.example.test_service.controller;

import com.example.test_service.entity.Config;
import com.example.test_service.repo.ConfigRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.test_service.logging.LoggerInterceptor.*;
@Slf4j
@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ConfigController {
    private final ConfigRepo configRepo;

    @Autowired
    public ConfigController(ConfigRepo configRepo) {
        this.configRepo = configRepo;
    }

    @PostMapping(path = "/create/", consumes = "text/plain")
    public Config createConfig(@RequestBody String params) {
        UUID configUUID = UUID.randomUUID();
        MDC.put(CONFIG_UUID, String.valueOf(configUUID));
        LocalDate createdAt = LocalDate.now();
        log.info("Create new config");
        return configRepo.save(new Config(configUUID,params, createdAt));
    }

    @PostMapping(path = "/config/{uuid}", consumes = "text/plain")
    public ResponseEntity<Config> updateConfig(@RequestBody String params, @PathVariable("uuid") UUID uuid) {
        MDC.put(CONFIG_UUID, String.valueOf(uuid));
        log.info("Get request to update config");
        int res = configRepo.updateByUUID(params, uuid);
        if(res > 0) {
            return new ResponseEntity<>(configRepo.findByConfigUUID(uuid).get(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/config/{uuid}")
    public ResponseEntity<Config> checkConfig(@PathVariable("uuid") UUID uuid) {
        MDC.put(CONFIG_UUID, String.valueOf(uuid));
        log.info("Get request to check config");
        Optional<Config> config = configRepo.findByConfigUUID(uuid);
        return config.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/config/all")
    public List<Config> allConfig() {
        return configRepo.findAll();
    }

    @DeleteMapping("/config/{uuid}")
    public void deleteConfig(@PathVariable("uuid") UUID configUUID) {
        MDC.put(CONFIG_UUID, String.valueOf(configUUID));
        log.info("Get request to delete config");
        configRepo.deleteByConfigUUID(configUUID);
    }
}
