package com.cbu.backend.studyactivity;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cbu.backend.global.IdResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityIdResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.studyactivity.dto.StudyActivityRequestFixture;
import com.cbu.backend.support.fixture.studyactivity.dto.StudyActivityResponseFixture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@WebMvcTest(StudyActivityController.class)
class StudyActivityControllerTest extends RestDocumentTest {

    @MockBean private StudyActivityService studyActivityService;

    @Test
    @DisplayName("스터디 일지 생성")
    void saveStudyActivity() throws Exception {
        // given
        IdResponse<Long> expected = new IdResponse<>(1L);
        given(studyActivityService.saveStudyActivity(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-activities")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyActivityRequestFixture.SAMPLE1
                                                        .tostudyActivityRequest())));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(expected.getId()));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "create study activity",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 일지 수정")
    void putStudyActivity() throws Exception {
        // given
        willDoNothing().given(studyActivityService).updateStudyActivity(any(), any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/study-activities/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyActivityRequestFixture.SAMPLE1
                                                        .tostudyActivityRequest())));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "update study activity",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 일지 삭제")
    void deleteStudyActivity() throws Exception {
        // given
        IdResponse<Long> expected = new IdResponse<>(1L);
        willDoNothing().given(studyActivityService).deleteStudyActivity(any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        delete("/study-activities/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "delete study activity",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 일지 단일 조회")
    void getStudyActivity() throws Exception {
        // given
        StudyActivityResponse expected =
                StudyActivityResponseFixture.SAMPLE1.toStudyActivityResponse();
        given(studyActivityService.findStudyActivity(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(get("/study-activities/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(expected.getTitle()));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get study activity detail",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디그룹 별 스터디 일지 리스트 조회")
    void getStudyActivityList() throws Exception {
        // given
        StudyActivityResponse expected1 =
                StudyActivityResponseFixture.SAMPLE1.toStudyActivityResponse();
        StudyActivityResponse expected2 =
                StudyActivityResponseFixture.SAMPLE2.toStudyActivityResponse();
        given(studyActivityService.findStudyActivityListByStudyGroupId(any()))
                .willReturn(List.of(expected1, expected2));

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-activities?studyGroup=1")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get study activity list",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
