package com.bank.accounts.infrastructure.adapter.outbound.persistence;

import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.application.port.outbound.CreditAccountPort;
import com.bank.accounts.application.port.outbound.DebitAccountPort;
import com.bank.accounts.application.port.outbound.LoadAccountPort;
import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
public class AccountPersistenceAdapter implements CreateAccountPort, LoadAccountPort, DebitAccountPort, CreditAccountPort {
    private final AccountJpaRepository repository;

    @Override
    public Account save(Account account) {
        AccountJpaEntity accountJpaEntity = repository.save(AccountJpaEntity.fromDomain(account));
        return accountJpaEntity.toDomain();
    }

    @Override
    public Optional<Account> load(AccountId accountId) {
        return repository.findById(accountId.value())
                .map(AccountJpaEntity::toDomain);
    }

    @Override
    public void debit(AccountId accountId, BigDecimal amount) {
        Optional<AccountJpaEntity> accountJpaEntity = repository.findById(accountId.value());
        if (accountJpaEntity.isPresent()) {
            BigDecimal balance = accountJpaEntity.get().getBalance();
            accountJpaEntity.get().setBalance(balance.subtract(amount));
        }
    }

    @Override
    public void credit(AccountId accountId, BigDecimal amount) {
        Optional<AccountJpaEntity> accountJpaEntity = repository.findById(accountId.value());
        if (accountJpaEntity.isPresent()) {
            BigDecimal balance = accountJpaEntity.get().getBalance();
            accountJpaEntity.get().setBalance(balance.add(amount));
        }
    }
}
