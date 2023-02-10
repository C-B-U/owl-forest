package com.cbu.backend.member;

import com.cbu.backend.member.domain.AcademicStatus;
import com.cbu.backend.member.domain.Major;
import com.cbu.backend.member.dto.MemberPrivacyResponse;
import com.cbu.backend.member.dto.MemberResponse;
import com.cbu.backend.member.dto.MemberSummaryResponse;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.support.docs.RestDocumentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.UUID;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@DisplayName("MemberController에서")
class MemberControllerTest extends RestDocumentTest {
    @MockBean private MemberService memberService;

    @Test
    @DisplayName("로그인한 유저 정보를 수정하는가")
    void successPutUser() throws Exception {
        // given
        UpdateMemberRequest request =
                new UpdateMemberRequest(
                        "test_76ca4ff20751",
                        "test_0053924831c5",
                        "test_ad40e3ba2f88",
                        AcademicStatus.ATTEND,
                        Major.COMPUTER,
                        Major.MEDIA_DESIGN,
                        "test_66614058107f",
                        1,
                        "test_413294765eab",
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
                .andDo(document("update member", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("유저 전체 목록을 가져오는가")
    void successGetAllUser() throws Exception {
        // given
        when(memberService.findAll(any())).thenReturn(
                List.of(
                        new MemberSummaryResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "profile"),
                        new MemberSummaryResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "profile"),
                        new MemberSummaryResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "profile"),
                        new MemberSummaryResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "profile"),
                        new MemberSummaryResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "profile")
                ));
        // when
        ResultActions perform =
                mockMvc.perform(get("/members"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("find all member", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("유저 단일 조회를 수행하는가")
    void successGetByIdUser() throws Exception {
        // given
        when(memberService.findById(any())).thenReturn(new MemberResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "email.ac.com","http://blog.com","phjppo0918","자기소개입니다","profile"));
        // when
        ResultActions perform =
                mockMvc.perform(get("/members/{id}", UUID.randomUUID()));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("find member", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("유저 개인정보 포함 조회를 수행하는가")
    void successGetByIdPrivacyUser() throws Exception {
        // given
        when(memberService.findPrivacyById(any())).thenReturn(new MemberPrivacyResponse(UUID.randomUUID(), "이름", 2, Major.COMPUTER, "email.ac.com","http://blog.com","phjppo0918","자기소개입니다","profile", "2018314014", "010-0000-1234"));
        // when
        ResultActions perform =
                mockMvc.perform(get("/members/{id}/privacy", UUID.randomUUID()));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("find member privacy", getDocumentRequest(), getDocumentResponse()));
    }

}
