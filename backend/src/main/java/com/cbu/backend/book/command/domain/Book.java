package com.cbu.backend.book.command.domain;

import com.cbu.backend.authaccount.entity.MemberNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Getter @EmbeddedId private BookNo id;

    @Column(nullable = false)
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;
    private Integer price;
    private LocalDate  publishAt;
    @Column(nullable = false)
    private MemberNo registrant;

    @Builder
    public Book(BookNo id, String title, String author, String publisher, String imageUrl, Integer price, LocalDate publishAt, MemberNo registrant) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishAt = publishAt;
        this.registrant = registrant;
    }
}
