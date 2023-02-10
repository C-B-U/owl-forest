package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentResponse;
import com.cbu.backend.bookreviewcomment.dto.Writer;
import com.cbu.backend.support.docs.RestDocumentTest;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookReviewCommentController.class)
@DisplayName("BookReviewCommentController에서")
class BookReviewCommentControllerTest extends RestDocumentTest {
    @MockBean private BookReviewCommentService bookReviewCommentService;

    @Test
    @DisplayName("저장을 수행하는가")
    void successSave() throws Exception {
        //given
        BookReviewCommentRequest request = new BookReviewCommentRequest(5L, null, "댓글내용");
        //when
        ResultActions perform =
                mockMvc.perform(
                        post("/book-review-comments")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(toRequestBody(request)));
        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("save book review comment", getDocumentRequest(), getDocumentResponse()));

    }

    @Test
    @DisplayName("BookReviewId를 기점으로 전체조회를 수행하는가")
    void successFindAllByBookReviewID() throws Exception {
        //given
        when(bookReviewCommentService.findByBookReviewId(any())).thenReturn(
                List.of(
                        new BookReviewCommentResponse(5L, new Writer(UUID.randomUUID(), "작성자 이름"), "댓글 내용", LocalDateTime.now()),
                        new BookReviewCommentResponse(6L, new Writer(UUID.randomUUID(), "작성자 이름"), "댓글 내용", LocalDateTime.now()),
                        new BookReviewCommentResponse(7L, new Writer(UUID.randomUUID(), "작성자 이름"), "댓글 내용", LocalDateTime.now()),
                        new BookReviewCommentResponse(8L, new Writer(UUID.randomUUID(), "작성자 이름"), "댓글 내용", LocalDateTime.now())
                ));
        //when
        ResultActions perform =
                mockMvc.perform(
                        get("/book-review-comments")
                                .param("bookReviewId", "5"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("find all book review comment", getDocumentRequest(), getDocumentResponse()));
    }
}