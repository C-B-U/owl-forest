package com.cbu.backend.bookreviewcomment.command.infra;

import com.cbu.backend.bookreviewcomment.command.domain.BookReviewComment;
import com.cbu.backend.bookreviewcomment.command.domain.BookReviewCommentNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewCommentRepository extends JpaRepository<BookReviewComment, BookReviewCommentNo> {
}
