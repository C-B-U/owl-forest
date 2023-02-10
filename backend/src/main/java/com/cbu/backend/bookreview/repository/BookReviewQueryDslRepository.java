package com.cbu.backend.bookreview.repository;

import com.cbu.backend.bookreview.BookReview;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookReviewQueryDslRepository {
    List<BookReview> findAllBy(Pageable pageable, BookReviewQueryOption option);
}
