package com.cbu.backend.bookreviewcomment.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewCommentRequest {
    private AccountNo writer;
    @NotBlank private String bookReviewId;

    private String parentId;
    @NotBlank private String content;

    public BookReviewCommentRequest toBookReviewRequest(AccountNo writer) {
        return new BookReviewCommentRequest(writer, bookReviewId, parentId, content);
    }
}
