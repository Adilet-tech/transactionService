package com.example.Transactions.service;

import com.example.Transactions.model.Limit;
import com.example.Transactions.repository.LimitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LimitService {
    private final LimitRepository limitRepository;

    public Limit setNewLimit(BigDecimal limitSum) {
        LocalDate today = LocalDate.now();

        boolean exists = limitRepository.existsByLimitDate(today);
        if (exists) {
            throw new IllegalStateException("Лимит уже установлен на сегодня. Нельзя изменить.");
        }

        Limit newLimit = new Limit();
        newLimit.setLimitSum(limitSum.doubleValue());
        newLimit.setLimitDate(today);

        return limitRepository.save(newLimit);
    }

    public List<Limit> getAllLimits() {
        return limitRepository.findAll();
    }
}
