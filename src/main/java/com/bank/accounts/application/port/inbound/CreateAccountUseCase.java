package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.AccountId;

import java.math.BigDecimal;

public interface CreateAccountUseCase {
    AccountId create(String customerId, BigDecimal amount);
}
