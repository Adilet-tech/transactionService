package com.example.Transactions.service;

import com.example.Transactions.model.Transaction;
import com.example.Transactions.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepository;

	@InjectMocks
	private TransactionService transactionService;

	@Test
	void testGetExceededTransactions() {
		BigDecimal limit = BigDecimal.valueOf(1000);
		List<Transaction> mockTransactions = List.of(new Transaction(), new Transaction());

		when(transactionRepository.findBySumGreaterThan(limit)).thenReturn(mockTransactions);

		List<Transaction> result = transactionService.getExceededTransactions(limit);

		assertEquals(2, result.size());
		verify(transactionRepository, times(1)).findBySumGreaterThan(limit);
	}
}
