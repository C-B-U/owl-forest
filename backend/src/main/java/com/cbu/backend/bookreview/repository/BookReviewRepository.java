package com.cbu.backend.bookreview.repository;

import com.cbu.backend.bookborrow.BookBorrow;
import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository
        extends JpaRepository<BookReview, Long>, BookReviewQueryDslRepository {

}
