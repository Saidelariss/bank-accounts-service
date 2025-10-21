package com.bank.accounts.infrastructure.adapter.inbound.web;

import com.bank.accounts.infrastructure.adapter.inbound.dto.AccountOperationRequest;
import com.bank.accounts.infrastructure.adapter.inbound.dto.AccountResponse;
import com.bank.accounts.infrastructure.adapter.inbound.dto.CreateAccountRequest;
import com.bank.accounts.application.port.inbound.CreateAccountUseCase;
import com.bank.accounts.application.port.inbound.CreditAccountUseCase;
import com.bank.accounts.application.port.inbound.DebitAccountUseCase;
import com.bank.accounts.application.port.inbound.GetBalanceUseCase;
import com.bank.accounts.domain.model.AccountId;
import com.bank.accounts.domain.model.Money;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetBalanceUseCase getBalanceUseCase;
    private final CreditAccountUseCase creditAccountUseCase;
    private final DebitAccountUseCase debitAccountUseCase;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@RequestBody @Valid CreateAccountRequest request) {
        AccountId accountId = createAccountUseCase.create(request.customerId(),request.amount());
        return ResponseEntity.ok(new AccountResponse(accountId.value(), BigDecimal.ZERO));
    }

    @PostMapping("/{id}/credit")
    public ResponseEntity<Void> credit(@PathVariable UUID id, @RequestBody @Valid AccountOperationRequest request) {
        creditAccountUseCase.credit(new AccountId(id), request.amount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/debit")
    public ResponseEntity<Void> debit(@PathVariable UUID id, @RequestBody @Valid AccountOperationRequest request) {
        debitAccountUseCase.debit(new AccountId(id), request.amount());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<AccountResponse> getBalance(@PathVariable UUID id) {
        Money balance = getBalanceUseCase.getBalance(new AccountId(id));

        return ResponseEntity.ok(new AccountResponse(id, balance.amount()));
    }
}
