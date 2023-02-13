package com.cbu.backend.studygroup;

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

import com.cbu.backend.studygroup.dto.StudyGroupIdResponse;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.studygroup.dto.StudyGroupRequestFixture;
import com.cbu.backend.support.fixture.studygroup.dto.StudyGroupResponseFixture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@WebMvcTest(StudyGroupController.class)
class StudyGroupControllerTest extends RestDocumentTest {

    @MockBean private StudyGroupService studyGroupService;

    @Test
    @DisplayName("스터디 그룹 생성")
    void saveStudyGroup() throws Exception {
        // given
        StudyGroupIdResponse expected = new StudyGroupIdResponse(1L);
        given(studyGroupService.saveStudyGroup(any())).willReturn(expected);

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
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(expected.getId()));

        // docs
        perform.andDo(print())
                .andDo(document("create study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 수정")
    void putStudyGroup() throws Exception {
        // given
        willDoNothing().given(studyGroupService).updateStudyGroup(any(), any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/study-groups/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        toRequestBody(
                                                StudyGroupRequestFixture.SAMPLE1
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
        willDoNothing().given(studyGroupService).addLike(any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/1/like-count/add")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "add study group like",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 좋아요 취소")
    void cancelLikeCount() throws Exception {
        // given
        willDoNothing().given(studyGroupService).cancelLike(any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/1/like-count/cancel")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "cancel study group like",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 종료")
    void finishStudy() throws Exception {
        // given
        willDoNothing().given(studyGroupService).finishStudy(any());

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/study-groups/1/finish").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("finish study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 삭제")
    void deleteStudyGroup() throws Exception {
        // given
        willDoNothing().given(studyGroupService).deleteStudyGroup(any());

        // when
        ResultActions perform =
                mockMvc.perform(delete("/study-groups/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("delete study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 단건 조회")
    void getStudyGroup() throws Exception {
        // given
        StudyGroupResponse expected = StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse();
        given(studyGroupService.findResponseById(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(get("/study-groups/1").contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.name").value("자바칩 스터디"));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get one study group",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 최신순 조회")
    void getAllByCreatedAt() throws Exception {
        // given
        given(studyGroupService.findAllStudyGroup(any()))
                .willReturn(
                        List.of(
                                StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse(),
                                StudyGroupResponseFixture.SAMPLE2.toStudyGroupResponse()));

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-groups?page=0&size=20&sort=createdAt,DESC")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get all study group by createdAt",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 좋아요순 조회")
    void getAllByLike() throws Exception {
        // given
        given(studyGroupService.findAllStudyGroup(any()))
                .willReturn(
                        List.of(
                                StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse(),
                                StudyGroupResponseFixture.SAMPLE2.toStudyGroupResponse()));

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-groups?page=0&size=20&sort=numOfLike,DESC")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get all study group by like",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 일지 개수순 조회")
    void getAllByStudyActivity() throws Exception {
        // given
        given(studyGroupService.findAllStudyGroup(any()))
                .willReturn(
                        List.of(
                                StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse(),
                                StudyGroupResponseFixture.SAMPLE2.toStudyGroupResponse()));

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-groups?page=0&size=20&sort=numOfStudyActivity,DESC")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get all study group by activity",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
