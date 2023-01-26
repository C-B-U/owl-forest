package com.cbu.backend.bookreview.query.infra;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.cbu.backend.authaccount.command.domain.QAuthAccount;
import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.QBook;
import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.QBookReview;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.QBookDetail;
import com.cbu.backend.bookreview.query.dto.QBookReviewResponse;
import com.cbu.backend.bookreview.query.dto.QWriter;
import com.cbu.backend.support.fixture.book.entity.BookFixture;
import com.cbu.backend.support.fixture.bookreview.entity.BookReviewFixture;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest // TODO DataJpaTest로 변환해야
@Transactional
class BookReviewQueryDslDaoTest {
    @Autowired EntityManager em;

    @Autowired JPAQueryFactory jpaQueryFactory;

    @Test
    @DisplayName("저장 및 조회가 잘 되는가")
    void saveAndFind() throws Exception {
        // given
        Book book = BookFixture.SAMPLE1.toEntity();
        BookReview bookReview = BookReviewFixture.SAMPLE1.toEntity();
        em.persist(book);
        em.persist(bookReview);

        // when

        QBook qBook = QBook.book;
        QBookReview qBookReview = QBookReview.bookReview;
        QAuthAccount qAuthAccount = QAuthAccount.authAccount;
        QWriter qWriter = new QWriter(qAuthAccount.id, qAuthAccount.memberInfo.nickname);
        QBookDetail qBookDetail =
                new QBookDetail(
                        qBook.id, qBook.title, qBook.author, qBook.publisher, qBook.imageUrl);
        QBookReviewResponse qBookReviewResponse =
                new QBookReviewResponse(
                        qBookReview.id,
                        qWriter,
                        qBookReview.title,
                        qBookReview.content,
                        qBookDetail,
                        qBookReview.likeCount,
                        qBookReview.score,
                        qBookReview.difficulty,
                        qBookReview.baseTime.createdAt);
        // when
        BookReviewResponse bookReviewResponse =
                jpaQueryFactory
                        .select(qBookReviewResponse)
                        .from(qBookReview, qBook)
                        .leftJoin(qBookReview)
                        .on(qBook.id.eq(qBookReview.bookId))
                        .fetchFirst();
        // then

        assertThat(bookReviewResponse.getTitle()).isEqualTo(bookReview.getTitle());
        assertThat(bookReviewResponse.getContent()).isEqualTo(bookReview.getContent());
        assertThat(bookReviewResponse.getBook().getId()).isEqualTo(bookReview.getBookId());

        assertThat(bookReviewResponse.getBook().getId()).isEqualTo(book.getId());
        assertThat(bookReviewResponse.getBook().getImageUrl()).isEqualTo(book.getImageUrl());
    }
}
