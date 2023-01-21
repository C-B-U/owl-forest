package com.cbu.backend.support.fixture.book.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookRequest;

import java.time.LocalDate;

public enum BookRequestFixture {

    HERRY_POTTER("해리포터", "8801037087550", "조엔 롤링", "국정원", "aaa.bb.com", 5000, LocalDate.now(), new AccountNo()),
    HONGGILDONG("홍길동전", "8801037087550", "조엔 롤링", "국정원", "aaa.bb.com", 500, LocalDate.now(), new AccountNo()),
    SIMCHUNG("심청전", "8801037087550", "조엔 롤링", "국정원", "aaa.bb.com", 5000, LocalDate.now(), new AccountNo()),
    SPL("스플", "8801037087550", "조엔 롤링", "국정원", "aaa.bb.com", 5000, LocalDate.now(), new AccountNo());

    private final String title;
    private final String isbn;
    private final String author;
    private final String publisher;
    private final String imageUrl;
    private final Integer price;
    private final LocalDate publishAt;
    private final AccountNo registrant;

    BookRequestFixture(String title, String isbn, String author, String publisher, String imageUrl, Integer price, LocalDate publishAt, AccountNo registrant) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishAt = publishAt;
        this.registrant = registrant;
    }

    public BookRequest getBookRequest() {
        return new BookRequest(isbn, title, author, publisher, imageUrl, price, publishAt, registrant);
    }
}
