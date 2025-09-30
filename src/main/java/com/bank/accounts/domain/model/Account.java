package com.bank.accounts.domain.model;

import java.time.Instant;

public record Account(String customerId, String accountNumber, String currency, Instant createdAt) {
}
