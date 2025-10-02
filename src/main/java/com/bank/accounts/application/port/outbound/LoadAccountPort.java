package com.bank.accounts.application.port.outbound;

import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;

import java.util.Optional;

public interface LoadAccountPort {
    Optional<Account> load(AccountId accountId);
}
