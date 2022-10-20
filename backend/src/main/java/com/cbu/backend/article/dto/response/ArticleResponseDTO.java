package com.cbu.backend.article.dto.response;

import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponseDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ArticleResponseDTO {
    private Long id;
    private BoardResponseDTO board;
    private String title;
    private String content;
    private MemberResponseDTO author;
    private Boolean isPublic;
    private List<ArticleCommentResponseDTO> comments;
}
