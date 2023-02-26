package com.cbu.backend.studyplan;

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
import com.cbu.backend.studyplan.dto.StudyPlanResponse;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.studyplan.dto.StudyPlanRequestFixture;
import com.cbu.backend.support.fixture.studyplan.dto.StudyPlanResponseFixture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(StudyPlanController.class)
class StudyPlanControllerTest extends RestDocumentTest {

    @MockBean private StudyPlanService studyPlanService;

    @Test
    @DisplayName("스터디 계획서 생성")
    void saveStudyPlan() throws Exception {
        // given
        IdResponse<Long> expected = new IdResponse<>(1L);
        given(studyPlanService.saveStudyPlan(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-plans")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyPlanRequestFixture.SAMPLE1
                                                        .toStudyPlanRequest())));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(expected.getId()));

        // docs
        perform.andDo(print())
                .andDo(document("create study plan", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 계획서 수정")
    void putStudyPlan() throws Exception {
        // given
        willDoNothing().given(studyPlanService).updateStudyPlan(any(), any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/study-plans/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyPlanRequestFixture.SAMPLE1
                                                        .toStudyPlanRequest())));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("update study plan", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 계획서 삭제")
    void deleteStudyPlan() throws Exception {
        // given
        willDoNothing().given(studyPlanService).deleteStudyPlan(any());

        // when
        ResultActions perform =
                mockMvc.perform(delete("/study-plans/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("delete study plan", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 계획서 조회")
    void getStudyPlan() throws Exception {
        // given
        StudyPlanResponse expected = StudyPlanResponseFixture.SAMPLE1.toStudyPlanResponse();
        given(studyPlanService.findStudyPlan(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(get("/study-plans/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(expected.getTitle()));

        // docs
        perform.andDo(print())
                .andDo(document("get study plan", getDocumentRequest(), getDocumentResponse()));
    }
}
