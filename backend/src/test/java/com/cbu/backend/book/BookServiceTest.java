package com.cbu.backend.book;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.book.BookRequestFixture;
import com.cbu.backend.support.fixture.member.MemberFixture;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@EnableDataBaseTest
@DisplayName("BookService에서")
@Slf4j
class BookServiceTest {
    @MockBean AuthService authService;
    @Autowired BookService bookService;
    @Autowired EntityManager em;

    @Nested
    @DisplayName("saveIfNotExists 호출시")
    class CallSaveIfNotExists {

        @Test
        @DisplayName("없는 상태이면 저장을 하는가")
        void checkSave() {
            // given
            BookRequest bookRequest = BookRequestFixture.HATE.toDto();
            Member member = MemberFixture.HERRY.toEntity();
            em.persist(member);
            when(authService.getLoginUser()).thenReturn(member);
            // when
            Book book = bookService.saveIfNotExists(bookRequest);
            // then
            log.info("{}", book.getId());
            log.info("{}", book.getIsbn());

            assertThat(book.getIsbn()).isEqualTo(bookRequest.getIsbn());
            assertThat(book.getAuthor()).isEqualTo(bookRequest.getAuthor());
            assertThat(book.getTitle()).isEqualTo(bookRequest.getTitle());
            assertThat(book.getPrice()).isEqualTo(bookRequest.getPrice());
        }

        @Test
        @DisplayName("isbn이 같은 책을 저장 안하고 그대로 가져오는가")
        void checkNotSaveIfSameIsbn() {
            // given
            BookRequest bookRequest = BookRequestFixture.HATE.toDto();
            Book book = bookService.saveIfNotExists(bookRequest);
            Member member = MemberFixture.HERRY.toEntity();
            em.persist(member);
            when(authService.getLoginUser()).thenReturn(member);
            // when
            Book newBook = bookService.saveIfNotExists(bookRequest);
            // then
            log.info("{}", book.getId());
            log.info("{}", book.getIsbn());
            assertThat(book.getId()).isNotNull();
            assertThat(book.getId()).isEqualTo(newBook.getId());
            assertThat(book.getIsbn()).isEqualTo(newBook.getIsbn());
        }
    }
}
