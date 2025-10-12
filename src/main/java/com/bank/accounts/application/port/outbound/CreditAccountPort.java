package com.bank.accounts.application.port.outbound;

import com.bank.accounts.domain.model.AccountId;

import java.math.BigDecimal;

public interface CreditAccountPort {
    void credit(AccountId accountId, BigDecimal amount);
}
