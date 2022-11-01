package com.cbu.backend.articlecomment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentRequestDTO {
    private String content;
    private Long writerId;
}
