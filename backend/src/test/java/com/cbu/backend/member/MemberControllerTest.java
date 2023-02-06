package com.cbu.backend.member;

import com.cbu.backend.support.docs.RestDocumentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@DisplayName("MemberController에서")
class MemberControllerTest extends RestDocumentTest {
    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("로그인한 유저 정보를 수정하는가")
    void successPutUser() throws Exception {
        // given
        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/users")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody("")));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("update user info", getDocumentRequest(), getDocumentResponse()));
    }
}