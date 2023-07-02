package com.example.test_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int configID;

    private UUID configUUID;

    private String params;

    private LocalDate createdAt;

    @OneToOne(mappedBy = "configID",cascade = CascadeType.ALL)
    @JsonIgnore
    private Calculation calculations;

    public Config(UUID configUUID,String params, LocalDate createdAt) {
        this.configUUID = configUUID;
        this.params = params;
        this.createdAt = createdAt;
    }
}
