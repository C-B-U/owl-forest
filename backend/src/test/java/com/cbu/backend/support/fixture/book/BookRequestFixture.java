package com.cbu.backend.support.fixture.book;

import com.cbu.backend.book.BookRequest;

import java.time.LocalDate;

public enum BookRequestFixture {
    HATE(
            "9791188116065",
            "미움 받을 용기",
            "독도독도",
            "test_b64e856b1458",
            "http://aaa.bb.com",
            62,
            LocalDate.now()),
    SPRING("9791188116065", "스프링 퀵 스타트", "체규태", "위키북스", "http://aaa.bb.com", 62, LocalDate.now());

    private final String isbn;
    private final String title;
    private final String author;
    private final String publisher;
    private final String imageUrl;
    private final Integer price;
    private final LocalDate publishAt;

    BookRequestFixture(
            String isbn,
            String title,
            String author,
            String publisher,
            String imageUrl,
            Integer price,
            LocalDate publishAt) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishAt = publishAt;
    }

    public BookRequest toDto() {
        return new BookRequest(isbn, title, author, publisher, imageUrl, price, publishAt);
    }
}
