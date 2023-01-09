package com.cbu.backend.article.mapper;

import com.cbu.backend.article.dto.request.ArticleRequest;
import com.cbu.backend.article.dto.response.ArticleResponse;
import com.cbu.backend.article.entity.Article;
import com.cbu.backend.articlecomment.mapper.ArticleCommentMapper;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.mapper.BoardMapper;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleMapper {

    private final MemberMapper memberMapper;
    private final BoardMapper boardMapper;
    private final ArticleCommentMapper articleCommentMapper;

    public Article toEntity(ArticleRequest dto, Board board, Member member) {
        return Article.builder()
                .author(member)
                .board(board)
                .title(dto.getTitle())
                .content(dto.getContent())
                .isPublic(dto.getIsPublic())
                .build();
    }

    public ArticleResponse toDto(Article entity) {
        return ArticleResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .isPublic(entity.getIsPublic())
                .author(memberMapper.toDto(entity.getAuthor()))
                .board(boardMapper.toDto(entity.getBoard()))
                .comments(articleCommentMapper.toListDto(entity.getComments()))
                .build();
    }
}
