package com.cbu.backend.member;

import com.cbu.backend.member.domain.AcademicStatus;
import com.cbu.backend.member.domain.Major;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import com.cbu.backend.member.service.MemberService;
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
        UpdateMemberRequest request = new UpdateMemberRequest(
                "test_76ca4ff20751",
                "test_0053924831c5",
                "test_ad40e3ba2f88",
                AcademicStatus.ATTEND,
                Major.COMPUTER,
                Major.MEDIA_DESIGN,
                "test_66614058107f",
                1,
                "test_413294765eab",
                "test_edabe30dee71",
                "test_f958a7f1746b");

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/members")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(toRequestBody(request)));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("update user info", getDocumentRequest(), getDocumentResponse()));
    }
}
