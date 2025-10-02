package com.bank.accounts.application.service;

import com.bank.accounts.application.port.inbound.GetBalanceUseCase;
import com.bank.accounts.application.port.outbound.LoadAccountPort;
import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;

public class GetBalanceService implements GetBalanceUseCase {
    public GetBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getBalance(AccountId accountId) {
        return loadAccountPort.load(accountId)
                .map(Account::getBalance)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}
