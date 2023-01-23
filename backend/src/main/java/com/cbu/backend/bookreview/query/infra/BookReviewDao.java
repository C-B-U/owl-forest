package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewDao extends JpaRepository<BookReview, BookReviewNo>, BookReviewQueryDslDao {
}
