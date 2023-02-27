package com.cbu.backend.bookborrow.dto;

import com.cbu.backend.bookreview.dto.BookDetail;
import com.cbu.backend.member.dto.MemberSummary;

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
    private MemberSummary lender;
    private MemberSummary borrower;
    private String location;
    private LocalDate endDate;
    private String kakaoUrl;
}
