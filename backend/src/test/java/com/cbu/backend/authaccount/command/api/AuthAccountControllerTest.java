package com.cbu.backend.authaccount.command.api;

import com.cbu.backend.authaccount.command.service.AuthAccountService;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.member.dto.MemberRequestFixture;
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

@WebMvcTest(AuthAccountController.class)
@DisplayName("AuthAccountController에서")
class AuthAccountControllerTest extends RestDocumentTest {

    @MockBean
    private AuthAccountService authAccountService;

    @Test
    @DisplayName("로그인한 유저 정보를 수정하는가")
    void successPutUser() throws Exception {
        //given
        //when
        ResultActions perform =
                mockMvc.perform(
                        put("/api/users")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                MemberRequestFixture.SAMPLE1.toMemberRequest()
                                        )
                                )
                );
        //then
        perform.andExpect(status().isNoContent());

        //docs
        perform.andDo(print())
                .andDo(document("update user info", getDocumentRequest(), getDocumentResponse()));
    }

}