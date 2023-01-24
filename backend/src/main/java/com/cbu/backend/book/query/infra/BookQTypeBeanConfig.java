package com.cbu.backend.book.query.infra;

import com.cbu.backend.book.command.domain.QBook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookQTypeBeanConfig {
    @Bean
    public QBook qBook() {
        return QBook.book;
    }
}
