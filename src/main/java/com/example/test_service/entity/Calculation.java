package com.example.test_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calculationID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "configID",referencedColumnName = "configID")
    private Config configID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusID",referencedColumnName = "statusID")
    private Status statusID;
}
