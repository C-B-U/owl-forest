package com.cbu.backend.article.mapper;

import com.cbu.backend.article.dto.request.ArticleRequestDTO;
import com.cbu.backend.article.dto.response.ArticleResponseDTO;
import com.cbu.backend.article.entity.Article;
import com.cbu.backend.articlecomment.mapper.ArticleCommentMapper;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.mapper.BoardMapper;
import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor
public class ArticleMapper {

    private final MemberMapper memberMapper;
    private final BoardMapper boardMapper;
    private final ArticleCommentMapper articleCommentMapper;

    public Article toEntity(ArticleRequestDTO dto, Board board, Member member) {
        return Article.builder()
                .author(member)
                .board(board)
                .title(dto.getTitle())
                .content(dto.getContent())
                .isPublic(dto.getIsPublic())
                .build();
    }

    public ArticleResponseDTO toDto(Article entity) {
        return ArticleResponseDTO.builder()
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
