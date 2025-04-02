package com.example.Transactions.service;

import com.example.Transactions.model.Transaction;
import com.example.Transactions.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getExceededTransactions(BigDecimal limit) {
        return transactionRepository.findBySumGreaterThan(limit);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
