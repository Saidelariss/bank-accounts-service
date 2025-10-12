package com.bank.accounts.config;

import com.bank.accounts.adapter.outbound.persistence.AccountJpaRepository;
import com.bank.accounts.adapter.outbound.persistence.AccountPersistenceAdapter;
import com.bank.accounts.application.port.inbound.CreateAccountUseCase;
import com.bank.accounts.application.port.inbound.CreditAccountUseCase;
import com.bank.accounts.application.port.inbound.DebitAccountUseCase;
import com.bank.accounts.application.port.inbound.GetBalanceUseCase;
import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.application.port.outbound.CreditAccountPort;
import com.bank.accounts.application.port.outbound.DebitAccountPort;
import com.bank.accounts.application.port.outbound.LoadAccountPort;
import com.bank.accounts.application.service.CreateAccountService;
import com.bank.accounts.application.service.CreditAccountService;
import com.bank.accounts.application.service.DebitAccountService;
import com.bank.accounts.application.service.GetBalanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsConfig {

    @Bean
    CreateAccountUseCase createAccountUseCase(CreateAccountPort createAccountPort){
        return new CreateAccountService(createAccountPort);
    }

    @Bean
    DebitAccountUseCase debitAccountUseCase(DebitAccountPort debitAccountPort,GetBalanceUseCase getBalanceUseCase){
        return new DebitAccountService(debitAccountPort,getBalanceUseCase);
    }

    @Bean
    CreditAccountUseCase creditAccountUseCase(CreditAccountPort creditAccountPort){
        return new CreditAccountService(creditAccountPort);
    }

    @Bean
    GetBalanceUseCase getBalanceUseCase(LoadAccountPort loadAccountPort){
        return new GetBalanceService(loadAccountPort);
    }

    @Bean
    CreateAccountPort createAccountPort(AccountJpaRepository repository){
        return new AccountPersistenceAdapter(repository);
    }

    @Bean
    LoadAccountPort loadAccountPort(AccountJpaRepository repository){
        return new AccountPersistenceAdapter(repository);
    }

    @Bean
    DebitAccountPort debitAccountPort(AccountJpaRepository repository){
        return new AccountPersistenceAdapter(repository);
    }

    @Bean
    CreditAccountPort creditAccountPort(AccountJpaRepository repository){
        return new AccountPersistenceAdapter(repository);
    }
}
