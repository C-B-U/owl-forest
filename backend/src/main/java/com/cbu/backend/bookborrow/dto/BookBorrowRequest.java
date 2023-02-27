package com.cbu.backend.bookborrow.dto;

import com.cbu.backend.book.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowRequest {
    @Valid
    private BookRequest book;
    @NotBlank
    private String location;
    private LocalDate endDate;
}
