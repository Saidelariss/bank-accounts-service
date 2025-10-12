package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.AccountId;

import java.math.BigDecimal;

public interface DebitAccountUseCase {
    void debit(AccountId accountId, BigDecimal amount);
}
