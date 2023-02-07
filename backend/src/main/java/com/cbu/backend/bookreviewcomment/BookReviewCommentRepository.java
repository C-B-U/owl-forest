package com.cbu.backend.bookreviewcomment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewCommentRepository extends JpaRepository<BookReviewComment, Long> {
    public List<BookReviewComment> findAllByBookReviewId(Long id);
}
