package com.cbu.backend.article.dto.response;

import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponse;
import com.cbu.backend.board.dto.response.BoardResponse;
import com.cbu.backend.member.dto.response.MemberResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ArticleResponse {
  private Long id;
  private BoardResponse board;
  private String title;
  private String content;
  private MemberResponse author;
  private Boolean isPublic;
  private List<ArticleCommentResponse> comments;
}