package com.cbu.backend.bookreview.repository;

import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.member.domain.QMember;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.cbu.backend.book.QBook.book;
import static com.cbu.backend.bookreview.QBookReview.bookReview;

@Repository
@RequiredArgsConstructor
public class BookReviewQueryDslRepositoryImpl implements BookReviewQueryDslRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final BookReviewOrderConverter orderConverter;

    @Override
    public List<BookReview> findAllBy(
            Pageable pageable, BookReviewQueryOption queryOption) {
        return jpaQueryFactory
                .select(bookReview)
                .from(bookReview)
                .where(generateWhereQuery(queryOption))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(orderConverter.convert(pageable.getSort()))
                .fetch();
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
                .ifPresent(w -> predicates.add(QMember.member.name.contains(w)));

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
