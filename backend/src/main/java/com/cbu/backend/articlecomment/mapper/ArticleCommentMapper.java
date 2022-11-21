package com.cbu.backend.articlecomment.mapper;

import com.cbu.backend.article.entity.Article;
import com.cbu.backend.articlecomment.dto.request.ArticleCommentRequest;
import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponse;
import com.cbu.backend.articlecomment.entity.ArticleComment;
import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@RequiredArgsConstructor
public class ArticleCommentMapper {

    private final MemberMapper memberMapper;

    public ArticleComment toEntity(ArticleCommentRequest dto, Article article, Member writer) {
        return ArticleComment.builder()
                .article(article)
                .writer(writer)
                .content(dto.getContent())
                .build();
    }

    public ArticleCommentResponse toDto(ArticleComment entity) {
        return ArticleCommentResponse.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .writer(memberMapper.toDto(entity.getWriter()))
                .createdAt(entity.getBaseTime().getCreatedAt())
                .updatedAt(entity.getBaseTime().getUpdatedAt())
                .build();
    }

    public List<ArticleCommentResponse> toListDto(List<ArticleComment> entitys) {
        return entitys.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}