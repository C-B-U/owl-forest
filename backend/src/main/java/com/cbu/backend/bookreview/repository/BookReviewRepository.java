package com.cbu.backend.bookreview.repository;

import com.cbu.backend.bookreview.entity.BookReview;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    List<BookReview> findAllByTitleContaining(String title);

    List<BookReview> findAllByOrderByStarDesc();

    List<BookReview> findAllByOrderByLevelDesc();

    @Query("SELECT b FROM BookReview AS b ORDER BY b.baseTime.createdAt desc")
    List<BookReview> findAllByOrderByCreateAtDesc();

}
