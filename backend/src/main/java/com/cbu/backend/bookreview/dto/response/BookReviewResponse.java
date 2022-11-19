package com.cbu.backend.bookreview.dto.response;

import com.cbu.backend.book.dto.response.BookResponse;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BookReviewResponse {

    private Long id;

    private BookResponse book;
    private MemberResponseDTO writer;
    private String title;
    private String review;
    private double star;
    private double level;
    private Boolean like;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
