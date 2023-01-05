package com.cbu.backend.articlecomment.service;

import com.cbu.backend.article.entity.Article;
import com.cbu.backend.article.service.ArticleService;
import com.cbu.backend.articlecomment.dto.request.ArticleCommentRequest;
import com.cbu.backend.articlecomment.dto.request.UpdateArticleCommentRequest;
import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponse;
import com.cbu.backend.articlecomment.entity.ArticleComment;
import com.cbu.backend.articlecomment.mapper.ArticleCommentMapper;
import com.cbu.backend.articlecomment.repository.ArticleCommentRepository;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
  private final ArticleCommentRepository articleCommentRepository;
  private final ArticleCommentMapper articleCommentMapper;

  private final ArticleService articleService;
  private final MemberService memberService;

  public ArticleCommentResponse save(Long boardId, ArticleCommentRequest dto) {
    Article article = articleService.getEntity(boardId);
    Member writer = memberService.getEntity(dto.getWriterId());
    ArticleComment savedArticleComment =
        articleCommentRepository.save(articleCommentMapper.toEntity(dto, article, writer));

    return articleCommentMapper.toDto(savedArticleComment);
  }

  public List<ArticleCommentResponse> findAllByBoardId(Long articleId) {
    return articleCommentRepository.findAllByArticleId(articleId).stream()
        .map(articleCommentMapper::toDto)
        .collect(Collectors.toList());
  }

  @Transactional
  public ArticleCommentResponse deleteById(Long id) {
    ArticleComment articleComment = getEntity(id);
    articleComment.getBaseTime().delete();
    return articleCommentMapper.toDto(articleComment);
  }

  public ArticleCommentResponse updateById(Long id, UpdateArticleCommentRequest dto) {
    ArticleComment articleComment = getEntity(id);
    modifyBoardComment(articleComment, dto);

    return articleCommentMapper.toDto(articleComment);
  }

  private void modifyBoardComment(ArticleComment articleComment, UpdateArticleCommentRequest dto) {
    articleComment.setContent(dto.getContent());
  }

  private ArticleComment getEntity(Long id) {
    return articleCommentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
