package com.cbu.backend.book.command.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookRequest;
import com.cbu.backend.book.command.infra.BookRepository;
import com.cbu.backend.support.database.EnableDataBaseTest;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@EnableDataBaseTest
@Slf4j
class BookServiceTest {

    private BookRepository bookRepository;

    private BookService bookService;

    @Autowired
    public BookServiceTest(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @Test
    @DisplayName("만약 신규 데이터면 저장하고, 기존에 있는 데이터면 아이디를 그대로 반환하는가")
    void checkSaveIfNotExists() throws Exception {
        // given
        BookRequest req1 =
                new BookRequest(
                                "0060930314",
                                "홍길동전",
                                "허균",
                                "조선",
                                "www.naver.com",
                                5000,
                                LocalDate.now())
                        .toBookRequest(new AccountNo());
        BookRequest req2 =
                new BookRequest(
                                "0060930315",
                                "심청전",
                                "작가미상",
                                "조선",
                                "www.naver.com",
                                5000,
                                LocalDate.now())
                        .toBookRequest(new AccountNo());
        // when
        bookService.saveIfNotExists(req1);
        bookService.saveIfNotExists(req2);
        // then
        assertThat(bookRepository.findAll()).hasSize(2);

        // when
        bookService.saveIfNotExists(req1);
        // then
        assertThat(bookRepository.findAll()).hasSize(2);
    }
}
