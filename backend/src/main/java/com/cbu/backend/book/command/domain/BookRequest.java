package com.cbu.backend.book.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookRequest {
    @ISBN private String isbn;
    @NotBlank private String title;
    private String author;
    private String publisher;
    @URL private String imageUrl;
    private Integer price;
    private LocalDate publishAt;
    private AccountNo registrant;

    public BookRequest(
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

    public BookRequest toBookRequest(AccountNo registrant) {
        return new BookRequest(
                isbn, title, author, publisher, imageUrl, price, publishAt, registrant);
    }
}
