package com.cbu.backend.book;

import com.cbu.backend.member.domain.Member;

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
    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String title;

    private String author;
    private String publisher;
    private String imageUrl;
    private Integer price;
    private LocalDate publishAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register_id", nullable = false)
    private Member register;

    @Column(unique = true)
    private String isbn;

    @Builder
    public Book(
            String title,
            String author,
            String publisher,
            String imageUrl,
            Integer price,
            LocalDate publishAt,
            Member register,
            String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishAt = publishAt;
        this.register = register;
        this.isbn = isbn;
    }
}
