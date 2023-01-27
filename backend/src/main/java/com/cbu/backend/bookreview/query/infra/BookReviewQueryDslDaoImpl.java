package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.authaccount.command.domain.QAuthAccount;
import com.cbu.backend.book.command.domain.QBook;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.command.domain.QBookReview;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.dto.QBookReviewResponse;
import com.cbu.backend.bookreview.query.dto.QBookReviewSummaryResponse;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookReviewQueryDslDaoImpl implements BookReviewQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;
    private final BookReviewOrderConverter bookReviewOrderConverter;
    private final QBookReviewResponse qBookReviewResponse;
    private final QBookReviewSummaryResponse qBookReviewSummaryResponse;
    private final QBookReview qBookReview;
    private final QBook qBook;
    private final QAuthAccount qAuthAccount;

    @Override
    public List<BookReviewSummaryResponse> findSummaryAll(
            Pageable pageable, BookReviewQueryOption queryOption) {
        return jpaQueryFactory
                .select(qBookReviewSummaryResponse)
                .from(qBookReview, qBook, qAuthAccount)
                .leftJoin(qBookReview)
                .on(qBook.id.eq(qBookReview.bookId))
                .leftJoin(qAuthAccount)
                .on(qAuthAccount.id.eq(qBookReview.writer))
                .where(generateWhereQuery(queryOption))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(bookReviewOrderConverter.convert(pageable.getSort()))
                .fetch();
    }

    @Override
    public Optional<BookReviewResponse> findResponseById(BookReviewNo id) {
        BookReviewResponse bookReviewResponse =
                jpaQueryFactory
                        .select(qBookReviewResponse)
                        .from(qBookReview, qBook, qAuthAccount)
                        .leftJoin(qBookReview)
                        .on(qBook.id.eq(qBookReview.bookId))
                        .leftJoin(qAuthAccount)
                        .on(qAuthAccount.id.eq(qBookReview.writer))
                        .where(qBookReview.id.eq(id))
                        .fetchFirst();

        return Optional.ofNullable(bookReviewResponse);
    }

    private Predicate[] generateWhereQuery(BookReviewQueryOption option) {
        List<Predicate> predicates = new ArrayList<>();
        Optional.ofNullable(option.getTitle())
                .ifPresent(t -> predicates.add(qBookReview.title.contains(t)));
        Optional.ofNullable(option.getContent())
                .ifPresent(c -> predicates.add(qBookReview.content.contains(c)));
        Optional.ofNullable(option.getBookname())
                .ifPresent(b -> predicates.add(qBook.title.contains(b)));
        Optional.ofNullable(option.getWriter())
                .ifPresent(w -> predicates.add(qAuthAccount.memberInfo.name.contains(w)));

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
