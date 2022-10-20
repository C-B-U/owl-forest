package com.cbu.backend.article.service;

import com.cbu.backend.article.dto.request.ArticleRequestDTO;
import com.cbu.backend.article.dto.response.ArticleResponseDTO;
import com.cbu.backend.article.entity.Article;
import com.cbu.backend.article.mapper.ArticleMapper;
import com.cbu.backend.article.repository.ArticleRepository;
import com.cbu.backend.articlecomment.service.ArticleCommentService;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    private final BoardService boardService;
    private final MemberService memberService;
    private final ArticleCommentService articleCommentService;

    public ArticleResponseDTO save(ArticleRequestDTO dto) {
        Member author = memberService.getEntity(dto.getAuthorId());
        Board board = boardService.getEntity(dto.getBoardId());
        Article savedArticle = articleRepository
                .save(articleMapper.toEntity(dto, board, author));

        return articleMapper.toDto(savedArticle);
    }

    public Article getEntity(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
