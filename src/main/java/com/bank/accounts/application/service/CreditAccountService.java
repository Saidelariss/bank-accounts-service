package com.bank.accounts.application.service;

import com.bank.accounts.application.port.inbound.CreditAccountUseCase;
import com.bank.accounts.application.port.outbound.CreditAccountPort;
import com.bank.accounts.domain.model.AccountId;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

public class CreditAccountService implements CreditAccountUseCase {
    private final CreditAccountPort creditAccountPort;

    public CreditAccountService(CreditAccountPort creditAccountPort) {
        this.creditAccountPort = creditAccountPort;
    }

    @Override
    @Transactional
    public void credit(AccountId accountId, BigDecimal amount) {
        creditAccountPort.credit(accountId, amount);
    }
}
