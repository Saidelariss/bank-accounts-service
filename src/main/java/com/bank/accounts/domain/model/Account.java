package com.bank.accounts.domain.model;

public class Account {
    private final AccountId id;
    private final String customerId;
    private Money balance;

    public Account(AccountId id, String customerId, Money balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    public AccountId getId() { return id; }
    public String getCustomerId() { return customerId; }
    public Money getBalance() { return balance; }

    public void deposit(Money money) {
        this.balance = new Money(this.balance.amount().add(money.amount()));
    }

    public void withdraw(Money money) {
        if (this.balance.amount().compareTo(money.amount()) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance = new Money(this.balance.amount().subtract(money.amount()));
    }
}
