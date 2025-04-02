package com.example.Transactions.controller;

import com.example.Transactions.model.ExchangeRate;
import com.example.Transactions.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange-rates")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/{currency}")
    public ResponseEntity<ExchangeRate> getRate(@PathVariable String currency) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(currency);
        return ResponseEntity.ok(exchangeRate);
    }
}
