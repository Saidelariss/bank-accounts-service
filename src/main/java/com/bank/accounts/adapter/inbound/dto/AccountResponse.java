package com.bank.accounts.adapter.inbound.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponse(UUID accountId, BigDecimal balance) {
}
