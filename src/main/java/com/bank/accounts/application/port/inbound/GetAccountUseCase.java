package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.Account;

import java.util.Optional;

public interface GetAccountUseCase {
    Optional<Account> getById(String accountNumber);
}
