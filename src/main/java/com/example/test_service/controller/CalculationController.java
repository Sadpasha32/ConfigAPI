package com.example.test_service.controller;

import com.example.test_service.entity.Calculation;
import com.example.test_service.repo.CalculationRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.example.test_service.logging.LoggerInterceptor.CONFIG_UUID;
@Slf4j
@RestController
@RequestMapping("/api/calc")
public class CalculationController {
    private final CalculationRepo calculationRepo;
    @Autowired
    public CalculationController(CalculationRepo calculationRepo) {
        this.calculationRepo = calculationRepo;
    }

    @GetMapping("/{uuid}")
    public Calculation checkConfig(@PathVariable("uuid") UUID configUUID) {
        MDC.put(CONFIG_UUID, String.valueOf(configUUID));
        log.info("Get request to check status");
        return calculationRepo.findByConfigUUID(configUUID);
    }
    @GetMapping("/all")
    public List<Calculation> checkAll() {
        return calculationRepo.findAll();
    }
}
