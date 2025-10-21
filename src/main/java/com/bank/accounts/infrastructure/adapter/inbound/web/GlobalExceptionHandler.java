package com.bank.accounts.infrastructure.adapter.inbound.web;

import com.bank.accounts.domain.exception.InsufficientBalanceException;
import com.bank.accounts.domain.exception.InvalidMoneyAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientBalanceException.class)
    ResponseEntity<Map<String, Object>> handleInsufficientBalance(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error","Insufficient balance",
                "message", ex.getMessage(),
                "timestamp", Instant.now()
        ));
    }

    @ExceptionHandler(InvalidMoneyAmountException.class)
    ResponseEntity<Map<String,Object>> handleInvalidMoneyAmount(InvalidMoneyAmountException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "error", "Invalid Amount",
                "message",ex.getMessage()
        ));
    }
}
