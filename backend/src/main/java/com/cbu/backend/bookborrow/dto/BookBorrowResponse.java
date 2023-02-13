package com.cbu.backend.bookborrow.dto;

import com.cbu.backend.bookreview.dto.BookDetail;
import com.cbu.backend.bookreview.dto.Writer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class BookBorrowResponse {
    private Long id;
    private BookDetail book;
    private Writer writer;
    private String location;
    private LocalDate endDate;
}
