package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.book.command.domain.QBook;
import com.cbu.backend.bookreview.command.domain.QBookReview;
import com.cbu.backend.bookreview.query.dto.QBookDetail;
import com.cbu.backend.bookreview.query.dto.QBookReviewResponse;
import com.cbu.backend.bookreview.query.dto.QBookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.dto.QBookSummary;
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
        return new QBookSummary(
                qBook.id, qBook.title, qBook.imageUrl
        );
    }

    @Bean
    public QBookReviewSummaryResponse qBookReviewSummaryResponse(QBookReview qBookReview, QBookSummary qBookSummary) {
        return new QBookReviewSummaryResponse(
                qBookReview.id,
                qBookReview.writer,
                qBookReview.title,
                qBookSummary,
                qBookReview.likeCount,
                qBookReview.score,
                qBookReview.difficulty,
                qBookReview.baseTime.createdAt
        );
    }

    @Bean
    public QBookReviewResponse qBookReviewResponse(QBookReview qBookReview, QBookDetail qBookDetail) {
        return new QBookReviewResponse(
                qBookReview.id,
                qBookReview.writer,
                qBookReview.title,
                qBookReview.content,
                qBookDetail,
                qBookReview.likeCount,
                qBookReview.score,
                qBookReview.difficulty,
                qBookReview.baseTime.createdAt);
    }
}
