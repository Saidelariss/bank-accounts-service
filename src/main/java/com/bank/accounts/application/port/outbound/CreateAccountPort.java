package com.bank.accounts.application.port.outbound;

import com.bank.accounts.domain.model.Account;

public interface CreateAccountPort {
    Account save(Account account);
}
