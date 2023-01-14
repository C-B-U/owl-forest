package com.cbu.backend.book.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;
    private Integer price;
    private LocalDate publishAt;
    private AccountNo registrant;
}
