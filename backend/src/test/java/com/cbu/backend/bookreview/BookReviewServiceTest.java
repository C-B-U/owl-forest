package com.cbu.backend.bookreview;

import com.cbu.backend.bookreview.dto.BookReviewRequest;
import com.cbu.backend.member.service.AuthService;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.bookreview.BookReviewRequestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@EnableDataBaseTest
@DisplayName("BookReviewService에서")
class BookReviewServiceTest {
    @MockBean
    AuthService authService;
    @Autowired
    BookReviewService bookReviewService;


    @Test
    @DisplayName("저장이 수행하는가")
    void checkSave() {
        //given
        BookReviewRequest bookReviewRequest = BookReviewRequestFixture.SAMPLE1.toDto();
        //when
        bookReviewService.saveBookReview(bookReviewRequest);
        //then

    }
}