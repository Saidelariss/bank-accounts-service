package com.bank.accounts.config;

import com.bank.accounts.adapter.outbound.persistence.AccountJpaRepository;
import com.bank.accounts.adapter.outbound.persistence.AccountPersistenceAdapter;
import com.bank.accounts.application.port.inbound.CreateAccountUseCase;
import com.bank.accounts.application.port.inbound.GetBalanceUseCase;
import com.bank.accounts.application.port.outbound.CreateAccountPort;
import com.bank.accounts.application.port.outbound.LoadAccountPort;
import com.bank.accounts.application.service.CreateAccountService;
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
}
