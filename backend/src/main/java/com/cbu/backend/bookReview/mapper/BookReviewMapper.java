package com.cbu.backend.bookReview.mapper;

import com.cbu.backend.bookReview.dto.request.CreateBookReviewRequestDTO;
import com.cbu.backend.bookReview.dto.response.BookReviewResponseDTO;
import com.cbu.backend.bookReview.entity.BookReview;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookReviewMapper {

    public BookReview mapToEntity(CreateBookReviewRequestDTO dto) {
        return BookReview.builder()
                .bookId(dto.getBookId())
                .writerId(dto.getWriterId())
                .detailReview(dto.getDetailReview())
                .simpleReview(dto.getSimpleReview())
                .starPoint(dto.getStarPoint())
                .starLevel(dto.getStarLevel())
                .createAt(dto.getCreateAt())
                .updateAt(dto.getUpdateAt())
                .build();
    }

    public BookReviewResponseDTO mapToDto(BookReview entity) {
        return BookReviewResponseDTO.builder()
                .id(entity.getId())
                .bookId(entity.getBookId())
                .writerId(entity.getWriterId())
                .detailReview(entity.getDetailReview())
                .simpleReview(entity.getSimpleReview())
                .starPoint(entity.getStarPoint())
                .starLevel(entity.getStarLevel())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();
    }
}
