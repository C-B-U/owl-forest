package com.cbu.backend.articlecomment.dto.response;

import com.cbu.backend.member.dto.response.MemberResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ArticleCommentResponse {
    private Long id;
    private String content;
    private MemberResponse writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
