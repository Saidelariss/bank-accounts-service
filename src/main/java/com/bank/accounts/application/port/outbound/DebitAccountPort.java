package com.bank.accounts.application.port.outbound;

import com.bank.accounts.domain.model.AccountId;

import java.math.BigDecimal;

public interface DebitAccountPort {
    void debit(AccountId accountId, BigDecimal amount);
}
