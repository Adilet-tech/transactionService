package com.example.Transactions.repository;

import com.example.Transactions.model.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LimitRepository extends JpaRepository<Limit, Long> {
    boolean existsByLimitDate(LocalDate limitDate);
}
