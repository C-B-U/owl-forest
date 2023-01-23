package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class BookReviewQueryDslDaoImpl implements BookReviewQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public BookReviewQueryDslDaoImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
    @Override
    public List<BookReviewSummaryResponse> findSummaryAll() {
        return null;
    }

    @Override
    public Optional<BookReviewResponse> findResponseById(BookReviewNo id) {
        return null;
    }
}
