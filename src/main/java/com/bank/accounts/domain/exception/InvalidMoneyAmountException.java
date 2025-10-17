package com.bank.accounts.domain.exception;

public class InvalidMoneyAmountException extends RuntimeException{
    public InvalidMoneyAmountException(String message){
        super(message);
    }
}
