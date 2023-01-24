package com.cbu.backend.bookreview.query.infra;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.support.fixture.book.entity.BookFixture;
import com.cbu.backend.support.fixture.bookreview.entity.BookReviewFixture;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@DisplayName("BookReviewQueryDslDaoImpl 클래스의")
class BookReviewQueryDslDaoImplTest {

    @Autowired EntityManager em;
    @Autowired JPAQueryFactory jpaQueryFactory;
    @Autowired BookReviewQueryDslDaoImpl bookReviewQueryDslDao;

    @Nested
    @DisplayName("단일 상세 조회가")
    class FindDetail {
        @Test
        @DisplayName("수행되는가")
        void successRun() throws Exception {
            // given
            jpaQueryFactory = new JPAQueryFactory(em);
            Book book = BookFixture.SAMPLE1.toEntity();
            BookReview bookReview = BookReviewFixture.SAMPLE1.toEntity();
            em.persist(book);
            em.persist(bookReview);
            // when
            Optional<BookReviewResponse> result =
                    bookReviewQueryDslDao.findResponseById(bookReview.getId());

            // then
            assertThat(result.isPresent()).isTrue();
            assertThat(result.get().getTitle()).isEqualTo(bookReview.getTitle());
            assertThat(result.get().getContent()).isEqualTo(bookReview.getContent());
            assertThat(result.get().getBook().getId()).isEqualTo(bookReview.getBookId());
            assertThat(result.get().getBook().getId()).isEqualTo(book.getId());
            assertThat(result.get().getBook().getImageUrl()).isEqualTo(book.getImageUrl());
        }
    }
}
