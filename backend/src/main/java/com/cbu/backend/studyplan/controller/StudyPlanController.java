package com.cbu.backend.studyplan.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.request.UpdateStudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.service.StudyPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/study-group")
@RequiredArgsConstructor
public class StudyPlanController {

    private final StudyPlanService studyPlanService;

    //스터디 계획서 생성
    @PostMapping("{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> create(StudyPlanRequest dto, @PathVariable Long studyGroupId) {
        StudyPlanResponse result = studyPlanService.create(dto, studyGroupId);
        ResponseFormat<StudyPlanResponse> responseBody = new ResponseFormat<>(ResponseStatus.POST_STUDYPLAN_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    // 스터디 계획 조회
    @GetMapping("{studyGroupId}/plan")
    public ResponseEntity<List<StudyPlanResponse>> getAll(){
        return ResponseEntity.ok(studyPlanService.getAll());
    }

    @PatchMapping("{studyGroupId}/plan")
    //스터디 계획서 수정
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> updateStudyPlan(UpdateStudyPlanRequest dto, @PathVariable Long studyGroupId){

        //StudyPlanResponseDTO result = studyPlanService.update(dto, studyGroupId);
        StudyPlanResponse updateStudyPlan = studyPlanService.update(dto, studyGroupId);
        ResponseFormat<StudyPlanResponse> responseBody = new ResponseFormat(ResponseStatus.UPDATE_STUDYPLAN_SUCCESS, updateStudyPlan);

        return ResponseEntity.ok(responseBody);
    }

    // 스터디 계획서 삭제
    @DeleteMapping("{studyGroupId}/plan")
    public ResponseEntity<ResponseFormat<StudyPlanResponse>> deleteStudyPlan(@PathVariable Long studyGroupId){
        StudyPlanResponse deleteStudyPlan = studyPlanService.delete(studyGroupId);
        ResponseFormat<StudyPlanResponse> responseBody = new ResponseFormat<>(ResponseStatus.DELETE_STUDYPLAN_SUCCESS, deleteStudyPlan);
        return ResponseEntity.ok(responseBody);
    }
}
