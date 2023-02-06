package com.cbu.backend.book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

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
    private UUID registrant;

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

    public BookRequest toBookRequest(UUID registrant) {
        return new BookRequest(
                isbn, title, author, publisher, imageUrl, price, publishAt, registrant);
    }
}
