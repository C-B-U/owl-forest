package com.cbu.backend.articlecomment.service;

import com.cbu.backend.article.entity.Article;
import com.cbu.backend.article.service.ArticleService;
import com.cbu.backend.articlecomment.dto.request.ArticleCommentRequestDTO;
import com.cbu.backend.articlecomment.dto.request.UpdateArticleCommentRequestDTO;
import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponseDTO;
import com.cbu.backend.articlecomment.entity.ArticleComment;
import com.cbu.backend.articlecomment.mapper.ArticleCommentMapper;
import com.cbu.backend.articlecomment.repository.ArticleCommentRepository;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleCommentMapper articleCommentMapper;

    private final ArticleService articleService;
    private final MemberService memberService;

    public ArticleCommentResponseDTO save(Long boardId, ArticleCommentRequestDTO dto) {
        Article article = articleService.getEntity(boardId);
        Member writer = memberService.getEntity(dto.getWriterId());
        ArticleComment savedArticleComment =
                articleCommentRepository.save(articleCommentMapper.toEntity(dto, article, writer));

        return articleCommentMapper.toDto(savedArticleComment);
    }

    public List<ArticleCommentResponseDTO> getAllByBoardId(Long articleId) {
        return articleCommentRepository.findAllByArticleId(articleId)
                .stream()
                .map(articleCommentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ArticleCommentResponseDTO delete(Long id) {
        ArticleComment articleComment = getEntity(id);
        articleComment.getBaseTime().delete();
        return articleCommentMapper.toDto(articleComment);
    }

    public ArticleCommentResponseDTO update(Long id, UpdateArticleCommentRequestDTO dto) {
        ArticleComment articleComment = getEntity(id);
        modifyBoardComment(articleComment, dto);

        return articleCommentMapper.toDto(articleComment);
    }

    private void modifyBoardComment(ArticleComment articleComment, UpdateArticleCommentRequestDTO dto) {
        articleComment.setContent(dto.getContent());
    }

    private ArticleComment getEntity(Long id) {
        return articleCommentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
