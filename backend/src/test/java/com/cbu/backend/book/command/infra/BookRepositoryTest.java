package com.cbu.backend.book.command.infra;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class BookRepositoryTest {

    @Autowired private BookRepository bookRepository;

    @Test
    @DisplayName("book 저장시 id가 자동생성 되면서 저장 되는가")
    void checkGenerateBookId() throws Exception {
        // given
        BookNo bookNo = bookRepository.nextNo();
        Book book = new Book(bookNo);
        // when
        Book result = bookRepository.save(book);
        Optional<Book> findBook = bookRepository.findById(bookNo);
        // then
        assertThat(result.getId()).isNotNull();
        assertThat(bookNo).isEqualTo(result.getId());
        assertThat(findBook).isPresent();
        assertThat(findBook.get().getId()).isEqualTo(result.getId());
    }
}
