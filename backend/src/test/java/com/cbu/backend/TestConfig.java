package com.cbu.backend;

import com.cbu.backend.book.BookRepository;
import com.cbu.backend.book.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Autowired private BookRepository bookRepository;

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository);
    }
}
