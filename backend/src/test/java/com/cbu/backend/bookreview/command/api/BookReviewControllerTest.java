package com.cbu.backend.bookreview.command.api;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.command.service.BookReviewService;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.bookreview.dto.BookReviewRequestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookReviewController.class)
class BookReviewControllerTest extends RestDocumentTest {
    @MockBean private BookReviewService bookReviewService;

    @Test
    @DisplayName("북리뷰 생성")
    void createBookReview() throws Exception {
        // given
        BookReviewNo expected = new BookReviewNo();
        given(bookReviewService.saveBookReview(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/api/book-reviews")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                BookReviewRequestFixture.SAMPLE1
                                                        .getBookReviewRequest())));
        // then
        perform.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(expected.getId().toString()));

        // docs
        perform.andDo(print())
                .andDo(document("create book review", getDocumentRequest(), getDocumentResponse()));
    }
}
