package com.cbu.backend.bookreview.command.infra;

import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, BookReviewNo> {
}
