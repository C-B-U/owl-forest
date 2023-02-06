package com.cbu.backend.bookreviewcomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewCommentRequest {
    @NotBlank private String bookReviewId;

    private String parentId;
    @NotBlank private String content;

    //    public BookReviewCommentRequest toBookReviewRequest(AccountNo writer) {
    //        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //        return new BookReviewCommentRequest(writer, bookReviewId, parentId, content);
    //    }
}
