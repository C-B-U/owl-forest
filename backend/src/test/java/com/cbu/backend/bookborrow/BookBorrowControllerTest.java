package com.cbu.backend.bookborrow;

import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;
import com.cbu.backend.bookreview.dto.BookDetail;
import com.cbu.backend.bookreview.dto.Writer;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.book.BookRequestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
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

@WebMvcTest(BookBorrowController.class)
@DisplayName("BookBorrowController에서")
class BookBorrowControllerTest extends RestDocumentTest {
    @MockBean private BookBorrowService bookBorrowService;

    @Test
    @DisplayName("bookBorrow 저장을 수행하는가")
    void successSave() throws Exception {
        //given
        BookBorrowRequest request = new BookBorrowRequest(BookRequestFixture.HATE.toDto(), "인천", LocalDate.now());
        when(bookBorrowService.create(any())).thenReturn(
                new BookBorrowResponse(5L,
                        new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                        new Writer(UUID.randomUUID(), "작성자")
                        ,"인천", LocalDate.now()));
        //when
        ResultActions perform = mockMvc.perform(
                post("/book-borrows")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                );

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create book borrow", getDocumentRequest(), getDocumentResponse()));
    }
    @Nested
    @DisplayName("bookBorrow 전체 조회를")
    class FindAdd {
        @Test
        @DisplayName("수행하는가")
        void successFindAll() throws Exception {
            //given
            BookBorrowRequest request = new BookBorrowRequest(BookRequestFixture.HATE.toDto(), "인천", LocalDate.now());
            when(bookBorrowService.findAll(any())).thenReturn(
                    List.of(new BookBorrowResponse(5L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()),
                            new BookBorrowResponse(4L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()),
                            new BookBorrowResponse(2L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()))

            );
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-borrows")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(toRequestBody(request))
            );

            // then
            perform.andExpect(status().isOk());

            // docs
            perform.andDo(print())
                    .andDo(document("find all book borrow", getDocumentRequest(), getDocumentResponse()));
        }

        @Test
        @DisplayName("book 이름을 필터로 조회하는가")
        void successFindAllByBookname() throws Exception {
            //given
            BookBorrowRequest request = new BookBorrowRequest(BookRequestFixture.HATE.toDto(), "인천", LocalDate.now());
            when(bookBorrowService.findAllByBookName(any())).thenReturn(
                    List.of(new BookBorrowResponse(5L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()),
                            new BookBorrowResponse(4L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()),
                            new BookBorrowResponse(2L,
                                    new BookDetail(5L, "책제목", "작가", "출판사", "책이미지"),
                                    new Writer(UUID.randomUUID(), "작성자")
                                    ,"인천", LocalDate.now()))

            );
            //when
            ResultActions perform = mockMvc.perform(
                    get("/book-borrows")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(toRequestBody(request))
                            .param("book-name", "책제목")
            );

            // then
            perform.andExpect(status().isOk());

            // docs
            perform.andDo(print())
                    .andDo(document("find all book borrow by book name", getDocumentRequest(), getDocumentResponse()));

        }

    }




}