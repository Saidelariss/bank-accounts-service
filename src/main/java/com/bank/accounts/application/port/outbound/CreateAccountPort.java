package com.bank.accounts.application.port.outbound;

import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountNumber;

public interface CreateAccountPort {
    AccountNumber save(Account account);
}
