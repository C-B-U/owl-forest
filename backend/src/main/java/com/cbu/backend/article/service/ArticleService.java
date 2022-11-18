package com.cbu.backend.article.service;

import com.cbu.backend.article.dto.request.ArticleRequest;
import com.cbu.backend.article.dto.response.ArticleResponse;
import com.cbu.backend.article.entity.Article;
import com.cbu.backend.article.mapper.ArticleMapper;
import com.cbu.backend.article.repository.ArticleRepository;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    private final BoardService boardService;
    private final MemberService memberService;

    public ArticleResponse create(Long boardId, ArticleRequest dto) {
        Member author = memberService.findById(dto.getAuthorId());
        Board board = boardService.getEntity(boardId);
        Article savedArticle = articleRepository
                .save(articleMapper.toEntity(dto, board, author));

        return articleMapper.toDto(savedArticle);
    }

    public List<ArticleResponse> findAllByBoardId(Long boardId, Pageable pageable) {
        return articleRepository.findAllByBoardId(boardId, pageable).stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }

    public ArticleResponse findById(Long id) {
        return articleMapper.toDto(getEntity(id));
    }

    public Article getEntity(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
