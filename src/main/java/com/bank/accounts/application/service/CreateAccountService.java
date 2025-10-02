package com.bank.accounts.application.service;

import com.bank.accounts.application.port.inbound.CreateAccountUseCase;
import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;

import java.math.BigDecimal;

public class CreateAccountService implements CreateAccountUseCase {
    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId create(String customerId) {
        Account account = new Account(AccountId.newId(), customerId, new Money(BigDecimal.ZERO));
        return createAccountPort.save(account).getId();
    }

}
