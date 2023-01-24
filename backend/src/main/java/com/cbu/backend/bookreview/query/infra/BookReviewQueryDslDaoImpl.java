package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.book.command.domain.QBook;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.command.domain.QBookReview;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.dto.QBookReviewResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookReviewQueryDslDaoImpl implements BookReviewQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;

    private final QBookReviewResponse qBookReviewResponse;
    private final QBookReview qBookReview;
    private final QBook qBook;

    @Override
    public List<BookReviewSummaryResponse> findSummaryAll() {
        return null;
    }

    @Override
    public Optional<BookReviewResponse> findResponseById(BookReviewNo id) {
        BookReviewResponse bookReviewResponse =
                jpaQueryFactory
                        .select(qBookReviewResponse)
                        .from(qBookReview, qBook)
                        .leftJoin(qBookReview)
                        .on(qBook.id.eq(qBookReview.bookId))
                        .fetchFirst();

        return Optional.ofNullable(bookReviewResponse);
    }
}
