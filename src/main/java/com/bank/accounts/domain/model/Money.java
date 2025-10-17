package com.bank.accounts.domain.model;

import com.bank.accounts.domain.exception.InvalidMoneyAmountException;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {
    public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidMoneyAmountException("Money must not be negative");
        }
    }
}
