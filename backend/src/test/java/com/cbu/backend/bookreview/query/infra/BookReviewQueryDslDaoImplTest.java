package com.cbu.backend.bookreview.query.infra;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.book.entity.BookFixture;
import com.cbu.backend.support.fixture.member.entity.AuthAccountFixture;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

@EnableDataBaseTest
@Slf4j
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
            Book book = BookFixture.SAMPLE1.toEntity();
            AuthAccount account = AuthAccountFixture.SAMPLE3.toEntity();
            BookReview bookReview =
                    new BookReview(
                            new BookReviewNo(),
                            account.getId(),
                            "adsf",
                            "content",
                            book.getId(),
                            5,
                            5);
            em.persist(book);
            em.persist(account);
            em.persist(bookReview);
            // when
            Optional<BookReviewResponse> result =
                    bookReviewQueryDslDao.findResponseById(bookReview.getId());
            BookReviewResponse bookReviewResponse = result.get();

            // then
            assertThat(result).isPresent();
            assertThat(bookReviewResponse.getTitle()).isEqualTo(bookReview.getTitle());
            assertThat(bookReviewResponse.getContent()).isEqualTo(bookReview.getContent());
            assertThat(bookReviewResponse.getBook().getId())
                    .isEqualTo(bookReview.getBookId().getId());
            assertThat(bookReviewResponse.getBook().getId()).isEqualTo(book.getId().getId());
            assertThat(bookReviewResponse.getBook().getImageUrl()).isEqualTo(book.getImageUrl());
        }
    }

    @Nested
    @DisplayName("전체 조회가")
    class FindAll {
        @Test
        @DisplayName("수행하는가")
        void successRun() throws Exception {
            // given
            Book book = BookFixture.SAMPLE1.toEntity();
            Book book2 = BookFixture.SAMPLE2.toEntity();
            AuthAccount account = AuthAccountFixture.SAMPLE3.toEntity();
            BookReview bookReview =
                    new BookReview(
                            new BookReviewNo(),
                            account.getId(),
                            "adsf",
                            "content",
                            book.getId(),
                            5,
                            5);
            BookReview bookReview2 =
                    new BookReview(
                            new BookReviewNo(),
                            account.getId(),
                            "adsf",
                            "content",
                            book2.getId(),
                            5,
                            5);
            BookReview bookReview3 =
                    new BookReview(
                            new BookReviewNo(),
                            account.getId(),
                            "adsf",
                            "content",
                            book.getId(),
                            5,
                            5);
            em.persist(book);
            em.persist(book2);
            em.persist(account);
            em.persist(bookReview);
            em.persist(bookReview2);
            em.persist(bookReview3);
            Pageable pageable =
                    new Pageable() {
                        @Override
                        public int getPageNumber() {
                            return 0;
                        }

                        @Override
                        public int getPageSize() {
                            return 10;
                        }

                        @Override
                        public long getOffset() {
                            return 0;
                        }

                        @Override
                        public Sort getSort() {
                            return Sort.by(Sort.Direction.DESC, "createdAt");
                        }

                        @Override
                        public Pageable next() {
                            return null;
                        }

                        @Override
                        public Pageable previousOrFirst() {
                            return null;
                        }

                        @Override
                        public Pageable first() {
                            return null;
                        }

                        @Override
                        public Pageable withPage(int pageNumber) {
                            return null;
                        }

                        @Override
                        public boolean hasPrevious() {
                            return false;
                        }
                    };
            // when

            List<BookReviewSummaryResponse> result =
                    bookReviewQueryDslDao.findSummaryAll(pageable, new BookReviewQueryOption());
            result.forEach(
                    r -> {
                        log.info(
                                "{}, {}, {}, {}",
                                r.getId(),
                                r.getBook().getId(),
                                r.getWriter().getId(),
                                r.getTitle());
                    });
            // then
            assertThat(result.size()).isEqualTo(3);
        }
    }
}
