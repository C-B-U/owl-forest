package com.cbu.backend.book.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @EmbeddedId private BookNo id;

    @Column(nullable = false)
    private String title;

    private String author;
    private String publisher;
    private String imageUrl;
    private Integer price;
    private LocalDate publishAt;

    @Column(unique = true)
    private String isbn;

    @AttributeOverride(name = "id", column = @Column(name = "registrant_id", nullable = false))
    @Embedded
    private AccountNo registrantId;

    @Builder
    public Book(
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
}
