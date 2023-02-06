package com.cbu.backend.book;

import static org.assertj.core.api.Assertions.assertThat;

import com.cbu.backend.member.service.AuthService;
import com.cbu.backend.support.database.EnableDataBaseTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@EnableDataBaseTest
@DisplayName("BookService에서")
class BookServiceTest {
    @MockBean AuthService authService;
    @Autowired BookService bookService;

    @Nested
    @DisplayName("saveIfNotExists 호출시")
    class CallSaveIfNotExists {
        @Test
        @DisplayName("없는 상태이면 저장을 하는가")
        void checkSave() {
            // given
            BookRequest bookRequest =
                    new BookRequest(
                            "798789789978",
                            "test_616ceb2a0fe5",
                            "test_24cbf9dc5e6d",
                            "test_0c649aef3ad3",
                            "test_b64e856b1458",
                            62,
                            LocalDate.now());
            // when
            Book book = bookService.saveIfNotExists(bookRequest);
            // then
            assertThat(book.getIsbn()).isEqualTo(bookRequest.getIsbn());
            assertThat(book.getAuthor()).isEqualTo(bookRequest.getAuthor());
            assertThat(book.getTitle()).isEqualTo(bookRequest.getTitle());
            assertThat(book.getPrice()).isEqualTo(bookRequest.getPrice());
        }

        @Test
        @DisplayName("isbn이 같은 책을 저장 안하고 그대로 가져오는가")
        void checkNotSaveIfSameIsbn() {
            // given
            BookRequest bookRequest =
                    new BookRequest(
                            "798789789978",
                            "test_616ceb2a0fe5",
                            "test_24cbf9dc5e6d",
                            "test_0c649aef3ad3",
                            "test_b64e856b1458",
                            62,
                            LocalDate.now());
            Book book = bookService.saveIfNotExists(bookRequest);
            // when
            Book newBook = bookService.saveIfNotExists(bookRequest);
            // then
            assertThat(book.getId()).isEqualTo(newBook.getId());
            assertThat(book.getIsbn()).isEqualTo(newBook.getIsbn());
        }
    }
}
