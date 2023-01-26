package com.cbu.backend.authaccount.query.infra;

import com.cbu.backend.authaccount.command.domain.QAuthAccount;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthAccountQTypeBeanConfig {
    @Bean
    public QAuthAccount qAuthAccount() {
        return QAuthAccount.authAccount;
    }
}
