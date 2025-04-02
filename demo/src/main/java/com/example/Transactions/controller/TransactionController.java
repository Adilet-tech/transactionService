package com.example.Transactions.controller;

import com.example.Transactions.model.Transaction;
import com.example.Transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/exceeded")
    public List<Transaction> getExceededTransactions(@RequestParam BigDecimal limit) {
        return transactionService.getExceededTransactions(limit);
    }

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction savedTransaction = transactionService.saveTransaction(transaction);
            return ResponseEntity.ok(savedTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при сохранении транзакции: " + e.getMessage());
        }
    }

}
