package com.cbu.backend.bookborrow.dto;

import com.cbu.backend.book.BookRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowRequest {
    private BookRequest book;
    private String location;
    private LocalDate endDate;
}
