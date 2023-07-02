package com.example.test_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusID;

    private String statusName;
    @OneToMany(mappedBy = "statusID", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Calculation> calculations;
}
