package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.authaccount.command.domain.QAuthAccount;
import com.cbu.backend.book.command.domain.QBook;
import com.cbu.backend.bookreview.command.domain.QBookReview;
import com.cbu.backend.bookreview.query.dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookReviewQTypeBeanConfig {

    @Bean
    public QBookReview qBookReview() {
        return QBookReview.bookReview;
    }

    @Bean
    public QBookDetail qBookDetail(QBook qBook) {
        return new QBookDetail(
                qBook.id, qBook.title, qBook.author, qBook.publisher, qBook.imageUrl);
    }

    @Bean
    public QBookSummary qBookSummary(QBook qBook) {
        return new QBookSummary(qBook.id, qBook.title, qBook.imageUrl);
    }
    @Bean
    public QWriter qWriter(QAuthAccount qAuthAccount) {
        return new QWriter(qAuthAccount.id, qAuthAccount.memberInfo.nickname);
    }

    @Bean
    public QBookReviewSummaryResponse qBookReviewSummaryResponse(QBookReview qBookReview, QWriter qWriter, QBookSummary qBookSummary) {
        return new QBookReviewSummaryResponse(
                qBookReview.id,
                qWriter,
                qBookReview.title,
                qBookSummary,
                qBookReview.likeCount,
                qBookReview.score,
                qBookReview.difficulty,
                qBookReview.baseTime.createdAt);
    }

    @Bean
    public QBookReviewResponse qBookReviewResponse(QBookReview qBookReview, QWriter qWriter, QBookDetail qBookDetail) {
        return new QBookReviewResponse(
                qBookReview.id,
                qWriter,
                qBookReview.title,
                qBookReview.content,
                qBookDetail,
                qBookReview.likeCount,
                qBookReview.score,
                qBookReview.difficulty,
                qBookReview.baseTime.createdAt);
    }
}
