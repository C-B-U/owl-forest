package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.book.command.domain.QBook.book;
import static com.cbu.backend.bookreview.command.domain.QBookReview.bookReview;

@Repository
@RequiredArgsConstructor
public class BookReviewQueryDslDaoImpl implements BookReviewQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;
    private final BookReviewOrderConverter bookReviewOrderConverter;
    private final BookReviewQDtoFactory qDtoFactory;

    @Override
    public List<BookReviewSummaryResponse> findSummaryAll(
            Pageable pageable, BookReviewQueryOption queryOption) {
        return jpaQueryFactory
                .select(qDtoFactory.qBookReviewSummaryResponse())
                .from(bookReview)
                .leftJoin(book)
                .on(book.id.eq(bookReview.bookId))
                .leftJoin(authAccount)
                .on(authAccount.id.eq(bookReview.writer))
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
                        .select(qDtoFactory.qBookReviewResponse())
                        .from(bookReview, book, authAccount)
                        .leftJoin(book)
                        .on(book.id.eq(bookReview.bookId))
                        .leftJoin(authAccount)
                        .on(authAccount.id.eq(bookReview.writer))
                        .where(bookReview.id.eq(id))
                        .fetchFirst();

        return Optional.ofNullable(bookReviewResponse);
    }

    private Predicate[] generateWhereQuery(BookReviewQueryOption option) {
        List<Predicate> predicates = new ArrayList<>();
        Optional.ofNullable(option.getTitle())
                .ifPresent(t -> predicates.add(bookReview.title.contains(t)));
        Optional.ofNullable(option.getContent())
                .ifPresent(c -> predicates.add(bookReview.content.contains(c)));
        Optional.ofNullable(option.getBookname())
                .ifPresent(b -> predicates.add(book.title.contains(b)));
        Optional.ofNullable(option.getWriter())
                .ifPresent(w -> predicates.add(authAccount.memberInfo.name.contains(w)));

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
