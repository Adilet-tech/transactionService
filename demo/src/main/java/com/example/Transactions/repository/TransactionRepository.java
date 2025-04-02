package com.example.Transactions.repository;

import com.example.Transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySumGreaterThan(BigDecimal amount);
}
