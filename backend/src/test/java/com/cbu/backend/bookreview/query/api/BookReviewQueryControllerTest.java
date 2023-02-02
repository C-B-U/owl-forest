package com.cbu.backend.bookreview.query.api;

import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.infra.BookReviewDao;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.bookreview.dto.BookReviewResponseFixture;
import com.cbu.backend.support.fixture.bookreview.dto.BookReviewSummaryResponseFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Optional;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookReviewQueryController.class)
@DisplayName("BookReviewQueryContreller 에서")
class BookReviewQueryControllerTest extends RestDocumentTest {
    @MockBean private BookReviewDao bookReviewDao;

    @Nested
    @DisplayName("Book review 전체 조회시")
    class findBookReview {

        @Test
        @DisplayName("전체 조회를 수행하는가")
        void successFindAll() throws Exception {
            // given
            List<BookReviewSummaryResponse> expected =
                    List.of(
                            BookReviewSummaryResponseFixture.SAMPLE1.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE2.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE3.toBookReviewSummaryResponse());
            given(bookReviewDao.findSummaryAll(any(), any())).willReturn(expected);
            // when
            ResultActions perform = mockMvc.perform(get("/book-reviews"));
            // then
            perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

            // docs
            perform.andDo(print())
                    .andDo(
                            document(
                                    "search book review list",
                                    getDocumentRequest(),
                                    getDocumentResponse()));
        }

        @Test
        @DisplayName("입력된 Pageable 값으로 조회를 수행하는가")
        void successFindAllPagingOption() throws Exception {
            // given
            List<BookReviewSummaryResponse> expected =
                    List.of(
                            BookReviewSummaryResponseFixture.SAMPLE1.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE2.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE3.toBookReviewSummaryResponse());
            given(bookReviewDao.findSummaryAll(any(), any())).willReturn(expected);
            // when
            ResultActions perform =
                    mockMvc.perform(
                            get("/book-reviews")
                                    .param("page", "0")
                                    .param("size", "12")
                                    .param("sort", "createdAt,desc"));

            // then
            perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

            // docs
            perform.andDo(print())
                    .andDo(
                            document(
                                    "search book review list Paging Option",
                                    getDocumentRequest(),
                                    getDocumentResponse()));
        }

        @Test
        @DisplayName("검색 조건 옵션을 포함하여 조회를 수행하는가")
        void successFindAllSearchOption() throws Exception {
            // given
            List<BookReviewSummaryResponse> expected =
                    List.of(
                            BookReviewSummaryResponseFixture.SAMPLE1.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE2.toBookReviewSummaryResponse(),
                            BookReviewSummaryResponseFixture.SAMPLE3.toBookReviewSummaryResponse());
            given(bookReviewDao.findSummaryAll(any(), any())).willReturn(expected);
            // when
            ResultActions perform =
                    mockMvc.perform(
                            get("/book-reviews")
                                    .param("title", "tititle")
                                    .param("content", "conconcon")
                                    .param("bookname", "herry")
                                    .param("writer", "popoter"));

            // then
            perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

            // docs
            perform.andDo(print())
                    .andDo(
                            document(
                                    "search book review list Search Option",
                                    getDocumentRequest(),
                                    getDocumentResponse()));
        }

        @Test
        @DisplayName("단일 조회를 수행하는가")
        void successFindById() throws Exception {
            // given
            BookReviewResponse expected = BookReviewResponseFixture.SAMPLE1.getBookReviewResponse();
            given(bookReviewDao.findResponseById(any())).willReturn(Optional.of(expected));
            // when
            ResultActions perform =
                    mockMvc.perform(get("/book-reviews/{id}", expected.getId()));
            // then
            perform.andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(expected.getId().toString()))
                    .andExpect(
                            jsonPath("$.writer.id")
                                    .value(expected.getWriter().getId().toString()))
                    .andExpect(
                            jsonPath("$.writer.nickname").value(expected.getWriter().getNickname()))
                    .andExpect(jsonPath("$.title").value(expected.getTitle()))
                    .andExpect(jsonPath("$.content").value(expected.getContent()))
                    .andExpect(
                            jsonPath("$.book.id")
                                    .value(expected.getBook().getId().toString()))
                    .andExpect(jsonPath("$.book.title").value(expected.getBook().getTitle()))
                    .andExpect(jsonPath("$.book.author").value(expected.getBook().getAuthor()))
                    .andExpect(
                            jsonPath("$.book.publisher").value(expected.getBook().getPublisher()))
                    .andExpect(jsonPath("$.book.imageUrl").value(expected.getBook().getImageUrl()))
                    .andExpect(jsonPath("$.likeCount").value(expected.getLikeCount()))
                    .andExpect(jsonPath("$.score").value(expected.getScore()))
                    .andExpect(jsonPath("$.difficulty").value(expected.getDifficulty()))
                    .andExpect(jsonPath("$.createdAt").value(expected.getCreatedAt().toString()));

            // docs
            perform.andDo(print())
                    .andDo(
                            document(
                                    "search book-review by id",
                                    getDocumentRequest(),
                                    getDocumentResponse()));
        }
    }
}
