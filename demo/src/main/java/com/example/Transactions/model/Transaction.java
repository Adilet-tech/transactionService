package com.example.Transactions.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long accountFrom;

    @Column(nullable = false)
    private Long accountTo;

    @Column(nullable = false)
    private String currencyShortname;

    @Column(nullable = false)
    private BigDecimal sum;

    @Column(nullable = false)
    private String expenseCategory;

    @Column(nullable = false)
    private OffsetDateTime datetime;
}
