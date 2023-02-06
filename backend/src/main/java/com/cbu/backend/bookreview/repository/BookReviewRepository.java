package com.cbu.backend.bookreview.repository;

import com.cbu.backend.bookreview.BookReview;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository
        extends JpaRepository<BookReview, Long>, BookReviewQueryDslRepository {}
