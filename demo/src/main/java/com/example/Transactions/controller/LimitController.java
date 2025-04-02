package com.example.Transactions.controller;

import com.example.Transactions.model.Limit;
import com.example.Transactions.service.LimitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/limits")
public class LimitController {
    private final LimitService limitService;

    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @GetMapping
    public ResponseEntity<List<Limit>> getAllLimits() {
        return ResponseEntity.ok(limitService.getAllLimits());
    }

    @PostMapping("/set")
    public ResponseEntity<Limit> setNewLimit(@RequestParam BigDecimal limitSum) {
        return ResponseEntity.ok(limitService.setNewLimit(limitSum));
    }
}
