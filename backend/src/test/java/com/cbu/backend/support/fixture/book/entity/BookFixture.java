package com.cbu.backend.support.fixture.book.entity;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public enum BookFixture {
    SAMPLE1(
            new BookNo(),
            "해리포터",
            "조엔 롤링",
            "국정원",
            "aaa.bb.com",
            5000,
            LocalDate.now(),
            "8801037087550",
            new AccountNo()),
    SAMPLE2(
            new BookNo(),
            "로허",
                    "조롤링",
                    "국원",
                    "aabb.com",
                    5000,
                    LocalDate.now(),
                    "8801097087550",
                    new AccountNo());
    private final BookNo id;
    private final String title;
    private final String author;
    private final String publisher;
    private final String imageUrl;
    private final Integer price;
    private final LocalDate publishAt;
    private final String isbn;
    private final AccountNo registrantId;

    BookFixture(
            BookNo id,
            String title,
            String author,
            String publisher,
            String imageUrl,
            Integer price,
            LocalDate publishAt,
            String isbn,
            AccountNo registrantId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishAt = publishAt;
        this.isbn = isbn;
        this.registrantId = registrantId;
    }

    public Book toEntity() {
        return new Book(
                id, title, author, publisher, imageUrl, price, publishAt, isbn, registrantId);
    }
}
