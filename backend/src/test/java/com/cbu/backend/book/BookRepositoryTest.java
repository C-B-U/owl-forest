package com.cbu.backend.book;

import static org.assertj.core.api.Assertions.assertThat;

import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.book.BookRequestFixture;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@EnableDataBaseTest
@Slf4j
@DisplayName("BookRepository에서")
class BookRepositoryTest {

    @Autowired BookRepository bookRepository;

    @Autowired EntityManager em;
    @Autowired BookMapper bookMapper;

    @Test
    @DisplayName("book 저장을 수행하는가")
    void checkSave() {
        // given
        BookRequest bookRequest = BookRequestFixture.HATE.toDto();
        // Member member = MemberFixture.HERRY.toEntity();
        // em.persist(member);
        // when
        Book saveBook = bookRepository.save(bookMapper.toEntity(bookRequest, null));
        // then
        assertThat(saveBook.getIsbn()).isEqualTo(bookRequest.getIsbn());
        assertThat(saveBook.getId()).isNotNull();
        log.info("{}", saveBook.getId());
    }
}
