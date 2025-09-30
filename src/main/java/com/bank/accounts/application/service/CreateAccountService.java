package com.bank.accounts.application.service;

import com.bank.accounts.application.port.inbound.CreateAccountUseCase;
import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountNumber;

import java.time.Instant;

public class CreateAccountService implements CreateAccountUseCase {
    private final CreateAccountPort createAccountPort;
    @Override
    public AccountNumber create(String customerId, String accountNumber, String currency) {
        Account account = new Account(customerId, accountNumber, currency, Instant.now());
        AccountNumber accountNumber = createAccountPort.save(account);

        return accountNumber;
    }
}
