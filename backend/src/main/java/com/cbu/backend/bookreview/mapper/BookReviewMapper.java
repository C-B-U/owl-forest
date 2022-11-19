package com.cbu.backend.bookreview.mapper;


import com.cbu.backend.book.entity.Book;
import com.cbu.backend.book.mapper.BookMapper;
import com.cbu.backend.bookreview.dto.request.CreateBookReviewRequest;
import com.cbu.backend.bookreview.dto.response.BookReviewResponse;
import com.cbu.backend.bookreview.entity.BookReview;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import org.springframework.stereotype.Component;

@Component
public class BookReviewMapper {
    BookMapper bookMapper;
    MemberMapper memberMapper;

    public BookReview mapToEntity(CreateBookReviewRequest dto, Book book, Member writer) {
        return BookReview.builder()
                .title(dto.getTitle())
                .review(dto.getReview())
                .star(dto.getStar())
                .level(dto.getLevel())
                .like(dto.getLike())
                .build();
    }

    public BookReviewResponse mapToDto(BookReview entity) {
        return BookReviewResponse.builder()
                .id(entity.getId())
                .book(bookMapper.toDto(entity.getBook()))
                .writer(memberMapper.toDto(entity.getWriter()))
                .title(entity.getTitle())
                .review(entity.getReview())
                .star(entity.getStar())
                .level(entity.getLevel())
                .like(entity.getLike())
                .createAt(entity.getBaseTime().getCreatedAt())
                .updateAt(entity.getBaseTime().getUpdatedAt())
                .build();
    }
}