package com.cbu.backend.bookreview.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.book.command.domain.QBook.book;
import static com.cbu.backend.bookreview.command.domain.QBookReview.bookReview;

import com.cbu.backend.bookreview.query.dto.*;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BookReviewQDtoFactory {
    private final QBookDetail qBookDetail =
            new QBookDetail(book.id.id, book.title, book.author, book.publisher, book.imageUrl);
    private final QBookSummary qBookSummary =
            new QBookSummary(book.id.id, book.title, book.imageUrl);

    private final QWriter qWriter = new QWriter(authAccount.id.id, authAccount.memberInfo.nickname);

    @Bean
    public QBookReviewSummaryResponse qBookReviewSummaryResponse() {
        return new QBookReviewSummaryResponse(
                bookReview.id.id,
                qWriter,
                bookReview.title,
                qBookSummary,
                bookReview.likeCount,
                bookReview.score,
                bookReview.difficulty,
                bookReview.baseTime.createdAt);
    }

    @Bean
    public QBookReviewResponse qBookReviewResponse() {
        return new QBookReviewResponse(
                bookReview.id.id,
                qWriter,
                bookReview.title,
                bookReview.content,
                qBookDetail,
                bookReview.likeCount,
                bookReview.score,
                bookReview.difficulty,
                bookReview.baseTime.createdAt);
    }
}
