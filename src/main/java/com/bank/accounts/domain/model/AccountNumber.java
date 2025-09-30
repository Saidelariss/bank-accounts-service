package com.bank.accounts.domain.model;

import java.util.Objects;
import java.util.UUID;

public record AccountNumber(UUID value) {
    public AccountNumber {
        Objects.requireNonNull(value);
    }
}
