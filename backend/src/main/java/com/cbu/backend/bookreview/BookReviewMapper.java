package com.cbu.backend.bookreview;

import com.cbu.backend.book.Book;
import com.cbu.backend.bookreview.dto.*;
import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.domain.Member;
import org.mapstruct.Mapping;

@Mapper
public interface BookReviewMapper {

    @Mapping(target = "book", source = "book")
    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "writer", source = "member")
    BookReview toEntity(BookReviewRequest dto, Book book, Member member);

    @Mapping(target="createdAt", source = "entity.baseTime.createdAt")
    BookReviewResponse toDto(BookReview entity);
    @Mapping(target="createdAt", source = "entity.baseTime.createdAt")
    BookReviewSummaryResponse toSummaryDto(BookReview entity);
    Writer toWriter(Member member);
    BookDetail toBookDetail(Book book);
    BookSummary toBookSummary(Book book);

}
