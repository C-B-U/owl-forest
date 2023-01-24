package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BookReviewQueryDslDaoImpl implements BookReviewQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BookReviewSummaryResponse> findSummaryAll() {
        return null;
    }

    @Override
    public Optional<BookReviewResponse> findResponseById(BookReviewNo id) {
        return null;
    }
}
