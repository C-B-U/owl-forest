package com.cbu.backend.book;

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
@AllArgsConstructor
public class BookRequest {
    @ISBN private String isbn;
    @NotBlank private String title;
    private String author;
    private String publisher;
    @URL private String imageUrl;
    private Integer price;
    private LocalDate publishAt;
}
