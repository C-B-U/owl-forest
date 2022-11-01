package com.cbu.backend.articlecomment.dto.response;

import com.cbu.backend.member.dto.response.MemberResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ArticleCommentResponseDTO {
    private Long id;
    private String content;
    private MemberResponseDTO writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
