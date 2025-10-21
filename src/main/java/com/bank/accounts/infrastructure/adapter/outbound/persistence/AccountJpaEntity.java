package com.bank.accounts.infrastructure.adapter.outbound.persistence;

import com.bank.accounts.domain.model.Account;
import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class AccountJpaEntity {
    @Id
    private UUID id;
    private String customerId;
    private BigDecimal balance;

    public static AccountJpaEntity fromDomain(Account account) {
        return new AccountJpaEntity(account.getId().value(), account.getCustomerId(), account.getBalance().amount());
    }

    public Account toDomain(){
        return new Account(new AccountId(id),customerId,new Money(balance));
    }
}
