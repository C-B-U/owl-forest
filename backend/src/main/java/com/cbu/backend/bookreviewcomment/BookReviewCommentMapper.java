package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentResponse;
import com.cbu.backend.bookreviewcomment.dto.Writer;
import com.cbu.backend.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookReviewCommentMapper {
    @Mapping(target = "bookReview", source = "bookReview")
    @Mapping(target = "writer", source = "writer")
    @Mapping(target = "content", source = "dto.content")
    BookReviewComment toEntity(BookReviewCommentRequest dto, BookReview bookReview, Member writer);

    @Mapping(target = "createdAt", source = "entity.baseTime.createdAt")
    BookReviewCommentResponse toDto(BookReviewComment entity);

    Writer toWriter(Member member);
}
