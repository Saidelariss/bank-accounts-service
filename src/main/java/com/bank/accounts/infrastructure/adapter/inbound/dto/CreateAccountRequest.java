package com.bank.accounts.infrastructure.adapter.inbound.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateAccountRequest(@NotEmpty String customerId, @NotNull BigDecimal amount) {
}
