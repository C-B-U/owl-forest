package com.cbu.backend.studyplan.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.service.StudyPlanService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 스터디 계획서 요청을 처리하는 API Controller
 *
 * @author ohksj77(김승진)
 */
@RestController
@RequestMapping("/api/study-group")
@RequiredArgsConstructor
public class StudyPlanController {

    private final StudyPlanService studyPlanService;

    // 스터디 계획서 생성
    @PostMapping("/{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> create(
            StudyPlanRequest dto, @PathVariable Long studyGroupId) {
        StudyPlanResponse studyPlan = studyPlanService.create(dto, studyGroupId);
        ResponseFormat<StudyPlanResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.POST_STUDYPLAN_SUCCESS, studyPlan);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }

    // 스터디 계획 조회
    @GetMapping("/{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> findAll(
            @PathVariable Long studyGroupId) {
        StudyPlanResponse studyPlan = studyPlanService.findStudyPlan(studyGroupId);
        ResponseFormat<StudyPlanResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.GET_STUDYPLAN_SUCCESS, studyPlan);

        return ResponseEntity.ok(responseFormat);
    }

    // 스터디 계획서 수정
    @PatchMapping("/{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> updateStudyPlan(
            StudyPlanRequest dto, @PathVariable Long studyGroupId) {
        StudyPlanResponse updateStudyPlan = studyPlanService.update(dto, studyGroupId);
        ResponseFormat<StudyPlanResponse> responseFormat =
                new ResponseFormat(ResponseStatus.UPDATE_STUDYPLAN_SUCCESS, updateStudyPlan);

        return ResponseEntity.ok(responseFormat);
    }

    // 스터디 계획서 삭제
    @DeleteMapping("/{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> deleteStudyPlan(
            @PathVariable Long studyGroupId) {
        StudyPlanResponse deleteStudyPlan = studyPlanService.delete(studyGroupId);
        ResponseFormat<StudyPlanResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.DELETE_STUDYPLAN_SUCCESS, deleteStudyPlan);

        return ResponseEntity.ok(responseFormat);
    }
}
