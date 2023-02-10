package com.cbu.backend.bookreview;

import com.cbu.backend.bookreview.dto.*;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.bookreview.BookReviewRequestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookReviewController.class)
@DisplayName("BookReviewController에서")
class BookReviewControllerTest extends RestDocumentTest {
    @MockBean
    private BookReviewService bookReviewService;

    @Test
    @DisplayName("북리뷰 저장을 수행하는가")
    void successSaveBookReview() throws Exception {
        //given
        when(bookReviewService.saveBookReview(any())).thenReturn(new BookReviewResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", "내용", new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"), 5, 5, 5, LocalDateTime.now()));
        BookReviewRequest request = BookReviewRequestFixture.SAMPLE1.toDto();
        //when
        ResultActions perform = mockMvc.perform(
                post("/book-reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request)));
        // then
        perform.andExpect(status().isCreated());
        // docs
        perform.andDo(print())
                .andDo(document("save book review", getDocumentRequest(), getDocumentResponse()));
    }

    @Nested
    @DisplayName("전체 조회시")
    class FindAll {
        @Test
        @DisplayName("별도 설정 없어도 수행하는가")
        void successGetAll() throws Exception {
            //given
            when(bookReviewService.findAll(any(), any())).thenReturn(List.of(
                    new BookReviewSummaryResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(2L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(3L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(4L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now())
            ));
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-reviews"));
            // then
            perform.andExpect(status().isOk());
            // docs
            perform.andDo(print())
                    .andDo(document("find all book review", getDocumentRequest(), getDocumentResponse()));
        }

        @Test
        @DisplayName("페이징 값 설정 하고 수행하는가")
        void successGetAllWithPaging() throws Exception {
            //given
            when(bookReviewService.findAll(any(), any())).thenReturn(List.of(
                    new BookReviewSummaryResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(2L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(3L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(4L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now())
            ));
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-reviews")
                            .param("page", "0")
                            .param("size", "12")
                            .param("sort", "createdAt,desc"));

            // then
            perform.andExpect(status().isOk());
            // docs
            perform.andDo(print())
                    .andDo(document("find all book review with paging", getDocumentRequest(), getDocumentResponse()));
        }

        @Test
        @DisplayName("검색 옵션 값 설정 하고 수행하는가")
        void successGetAllWithSearchOption() throws Exception {
            //given
            when(bookReviewService.findAll(any(), any())).thenReturn(List.of(
                    new BookReviewSummaryResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(2L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(3L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(4L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now())
            ));
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-reviews")
                            .param("content", "conconcon")
                            .param("bookname", "herry")
                            .param("writer", "popoter"));
            // then
            perform.andExpect(status().isOk());
            // docs
            perform.andDo(print()).andDo(document("find all book review with search option", getDocumentRequest(), getDocumentResponse()));;
        }

        @Test
        @DisplayName("페이징 및 검색 옵션 값 설정 하고 수행하는가")
        void successGetAllWithPagingAndSearchOption() throws Exception {
            //given
            when(bookReviewService.findAll(any(), any())).thenReturn(List.of(
                    new BookReviewSummaryResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(2L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(3L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now()),
                    new BookReviewSummaryResponse(4L, new Writer(UUID.randomUUID(), "작성자"), "제목", new BookSummary(5L, "책제목", "책이미지"), 5, 5, 5, LocalDateTime.now())
            ));
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-reviews")
                            .param("page", "0")
                            .param("size", "12")
                            .param("sort", "createdAt,desc")
                            .param("content", "conconcon")
                            .param("bookname", "herry")
                            .param("writer", "popoter")
            );
            // then
            perform.andExpect(status().isOk());
            // docs
            perform.andDo(print())
                    .andDo(document("find all book review with paging and search option", getDocumentRequest(), getDocumentResponse()));
        }
    }


    @Test
    @DisplayName("단일 조회를 수행하는가")
    void successGetById() throws Exception {
        //given
        when(bookReviewService.findById(any())).thenReturn(new BookReviewResponse(1L, new Writer(UUID.randomUUID(), "작성자"), "제목", "내용", new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"), 5, 5, 5, LocalDateTime.now()));
        //when
        ResultActions perform = mockMvc.perform(
                get("/book-reviews/{id}", 5L));
        // then
        perform.andExpect(status().isOk());
        // docs
        perform.andDo(print())
                .andDo(document("find book review", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("수정 요청을 수행하는가")
    void successUpdate() throws Exception {
        //given
        BookReviewRequest request = BookReviewRequestFixture.SAMPLE1.toDto();
        //when
        ResultActions perform = mockMvc.perform(
                put("/book-reviews/{id}", 5L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request)));
        // then
        perform.andExpect(status().isNoContent());
        // docs
        perform.andDo(print())
                .andDo(document("update book review", getDocumentRequest(), getDocumentResponse()));
    }
}