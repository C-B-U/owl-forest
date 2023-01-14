package com.cbu.backend.book.command.infra;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired private BookRepository bookRepository;

    @Test
    @DisplayName("book 저장시 id가 자동생성 되면서 저장 되는가")
    void checkGenerateBookId() throws Exception {
        // given
        BookNo bookNo = new BookNo("12345678");
        Book book = Book.builder().id(bookNo).title("홍길동전").registrant(new AccountNo(5L)).build();
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
        //given
        String isbn  = "12345678";
        BookNo bookNo = new BookNo(isbn);
        Book book = Book.builder().id(bookNo).title("홍길동전").registrant(new AccountNo(5L)).build();
        Book result = bookRepository.save(book);
        //when
        Optional<Book> findBook = bookRepository.findById_Isbn(isbn);
        //then
        assertThat(findBook).isPresent();
        assertThat(findBook.get().getId()).isEqualTo(bookNo);

    }

}
