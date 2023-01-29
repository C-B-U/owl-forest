package com.cbu.backend.book.command.infra;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.support.database.EnableDataBaseTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@EnableDataBaseTest
class BookRepositoryTest {

    @Autowired private BookRepository bookRepository;

    @Test
    @DisplayName("book 저장시 id가 자동생성 되면서 저장 되는가")
    void checkGenerateBookId() throws Exception {
        // given
        BookNo bookNo = new BookNo();
        Book book =
                Book.builder()
                        .id(bookNo)
                        .title("홍길동전")
                        .isbn("12345")
                        .registrantId(new AccountNo())
                        .build();
        // when
        Book result = bookRepository.save(book);
        Optional<Book> findBook = bookRepository.findById(bookNo);
        // then
        assertThat(result.getId()).isNotNull();
        assertThat(bookNo).isEqualTo(result.getId());
        assertThat(findBook).isPresent();
        assertThat(findBook.get().getId()).isEqualTo(result.getId());
    }

    @Test
    @DisplayName("isbn과 일치하는 Book을 찾는가")
    void checkFindByIsbn() throws Exception {
        // given
        String isbn = "12345678";
        BookNo bookNo = new BookNo();
        Book book =
                Book.builder()
                        .id(bookNo)
                        .title("홍길동전")
                        .isbn(isbn)
                        .registrantId(new AccountNo())
                        .build();
        Book result = bookRepository.save(book);
        // when
        Optional<Book> findBook = bookRepository.findByIsbn(isbn);
        // then
        assertThat(findBook).isPresent();
        assertThat(findBook.get().getId()).isEqualTo(bookNo);
    }
}
