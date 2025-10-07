package com.bank.accounts.adapter.outbound.persistence;

import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.application.port.outbound.LoadAccountPort;
import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AccountPersistenceAdapter implements CreateAccountPort, LoadAccountPort {
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
}
