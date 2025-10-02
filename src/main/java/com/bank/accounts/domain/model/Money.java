package com.bank.accounts.domain.model;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {
    public Money {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Money must not be non negative");
        }
    }
}
