package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.AccountId;

public interface CreateAccountUseCase {
    AccountId create(String customerId);
}
