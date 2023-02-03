package com.cbu.backend.studygroup.command.api;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.command.service.StudyGroupService;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.studygroup.dto.StudyGroupRequestFixture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(StudyGroupController.class)
class StudyGroupControllerTest extends RestDocumentTest {

    @MockBean private StudyGroupService studyGroupService;

    @Test
    @DisplayName("스터디 그룹 생성")
    void saveStudyGroup() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyGroupRequestFixture.SAMPLE1
                                                        .toStudyGroupRequest())));

        // then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expected.getId().toString()));

        // docs
        perform.andDo(print())
                .andDo(document("create study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 수정")
    void putStudyGroup() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/study-groups/" + expected.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyGroupRequestFixture.SAMPLE2
                                                        .toStudyGroupRequest())));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("update study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 좋아요 추가")
    void addLikeCount() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/" + expected.getId().toString() + "/like-count/add")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "update study group add like count",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 좋아요 취소")
    void cancelLikeCount() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/" + expected.getId().toString() + "/like-count/cancel")
                                .principal(loginUser)
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "update study group cancel like count",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 활동 마감")
    void finishStudy() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/" + expected.getId().toString() + "/finish")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "update study group finish",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 삭제")
    void deleteStudyGroup() throws Exception {
        // given
        StudyGroupNo expected = new StudyGroupNo();
        given(studyGroupService.save(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        delete("/study-groups/" + expected.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("delete study group", getDocumentRequest(), getDocumentResponse()));
    }
}
