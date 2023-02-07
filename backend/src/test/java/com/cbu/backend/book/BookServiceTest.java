package com.cbu.backend.book;

import com.cbu.backend.support.LoginTest;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.book.BookRequestFixture;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@EnableDataBaseTest
@DisplayName("BookService에서")
@Slf4j
class BookServiceTest extends LoginTest {
    @Autowired BookService bookService;

    @Nested
    @DisplayName("saveIfNotExists 호출시")
    class CallSaveIfNotExists {

        @Test
        @DisplayName("없는 상태이면 저장을 하는가")
        void checkSave() {
            // given
            BookRequest bookRequest = BookRequestFixture.HATE.toDto();
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
