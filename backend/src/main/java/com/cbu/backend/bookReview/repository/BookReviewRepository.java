package com.cbu.backend.bookReview.repository;

import com.cbu.backend.bookReview.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    List<BookReview> findBookReviewBySimpleReviewContaining(String title);

}
