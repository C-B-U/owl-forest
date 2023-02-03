package com.cbu.backend.studygroup.query.api;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.infra.StudyGroupDao;
import com.cbu.backend.support.docs.RestDocumentTest;
import com.cbu.backend.support.fixture.studygroup.dto.StudyGroupResponseFixture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@WebMvcTest(StudyGroupQueryController.class)
class StudyGroupQueryControllerTest extends RestDocumentTest {

    @MockBean private StudyGroupDao studyGroupDao;

    @Test
    @DisplayName("스터디 그룹 조회")
    void getStudyGroup() throws Exception {
        // given
        StudyGroupResponse expected = StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse();
        given(studyGroupDao.findResponseById(any())).willReturn(expected);
        String id = expected.getStudyGroupInfo().getId().toString();

        // when
        ResultActions perform =
                mockMvc.perform(get("/study-groups/" + id).contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.studyGroupInfo.id").value(id));

        // docs
        perform.andDo(print())
                .andDo(document("get study group", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 목록 최신순 조회")
    void getAllByCreatedAt() throws Exception {
        // given
        List<StudyGroupResponse> expected =
                List.of(
                        StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse(),
                        StudyGroupResponseFixture.SAMPLE2.toStudyGroupResponse());
        given(studyGroupDao.findAllStudyGroup(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-groups?page=1&size=20&sort=craetedAt,DESC")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(2));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get study group by createdAt",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("스터디 그룹 목록 좋아요순 조회")
    void getAllByLikeCount() throws Exception {
        // given
        List<StudyGroupResponse> expected =
                List.of(
                        StudyGroupResponseFixture.SAMPLE1.toStudyGroupResponse(),
                        StudyGroupResponseFixture.SAMPLE2.toStudyGroupResponse());
        given(studyGroupDao.findAllStudyGroup(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/study-groups/?page=1&size=20&sort=likeCount,DESC")
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(2));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get study group by likeCount",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
