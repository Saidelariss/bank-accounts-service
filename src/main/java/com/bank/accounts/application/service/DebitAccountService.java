package com.bank.accounts.application.service;

import com.bank.accounts.application.port.inbound.DebitAccountUseCase;
import com.bank.accounts.application.port.inbound.GetBalanceUseCase;
import com.bank.accounts.application.port.outbound.DebitAccountPort;
import com.bank.accounts.domain.exception.InsufficientBalanceException;
import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

public class DebitAccountService implements DebitAccountUseCase {
    private final DebitAccountPort debitAccountPort;
    private final GetBalanceUseCase getBalanceService;

    public DebitAccountService(DebitAccountPort debitAccountPort, GetBalanceUseCase getBalanceUseCase) {
        this.debitAccountPort = debitAccountPort;
        this.getBalanceService = getBalanceUseCase;
    }

    @Override
    @Transactional
    public void debit(AccountId accountId, BigDecimal amount) {
        Money balance = getBalanceService.getBalance(accountId);
        if (balance.amount().compareTo(amount) < 0)
            throw new InsufficientBalanceException("Insufficient balance, current balance : " + balance.amount() + " , requested debit is : " + amount);
        debitAccountPort.debit(accountId, amount);
    }
}
