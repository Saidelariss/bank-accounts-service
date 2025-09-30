package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.AccountNumber;

public interface CreateAccountUseCase {
    AccountNumber create(String customerId, String accountNumber, String currency);
}
