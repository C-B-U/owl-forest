package com.cbu.backend.article.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDTO {

    private String title;
    private String content;
    private Long authorId;
    private Long boardId;
    private Boolean isPublic;
}
