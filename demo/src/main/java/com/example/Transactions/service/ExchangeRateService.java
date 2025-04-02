package com.example.Transactions.service;

import com.example.Transactions.model.ExchangeRate;
import com.example.Transactions.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final RestTemplate restTemplate;

    public ExchangeRate getExchangeRate(String currency) {
        LocalDate today = LocalDate.now();
        Optional<ExchangeRate> rate = exchangeRateRepository.findByCurrencyAndDate(currency, today);

        return rate.orElseGet(() -> fetchAndSaveExchangeRate(currency, today));
    }

    private ExchangeRate fetchAndSaveExchangeRate(String currency, LocalDate date) {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/USD";
        Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);

        if (response == null || !response.containsKey("rates")) {
            throw new RuntimeException("Не удалось получить курсы валют");
        }

        Map<String, Double> rates = (Map<String, Double>) response.get("rates");
        Double exchangeRateValue = rates.get(currency);

        if (exchangeRateValue == null) {
            throw new RuntimeException("Валюта " + currency + " не найдена в API");
        }

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency(currency);
        exchangeRate.setRate(BigDecimal.valueOf(exchangeRateValue));
        exchangeRate.setDate(OffsetDateTime.from(date));

        return exchangeRateRepository.save(exchangeRate);
    }
}
