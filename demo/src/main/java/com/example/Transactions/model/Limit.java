package com.example.Transactions.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "limits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double limitSum;

    @Column(nullable = false)
    private LocalDate limitDate;

    @Column(nullable = false)
    private String limitCurrencyShortname;
}
