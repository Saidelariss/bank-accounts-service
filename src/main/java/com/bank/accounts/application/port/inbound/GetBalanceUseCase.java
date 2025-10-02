package com.bank.accounts.application.port.inbound;

import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;

public interface GetBalanceUseCase {
    Money getBalance(AccountId accountId);
}
