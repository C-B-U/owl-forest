package com.cbu.backend.studyplan.controller;

import com.cbu.backend.global.ResponseBody;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyPlan.dto.request.StudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.request.UpdateStudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.response.StudyPlanResponseDTO;
import com.cbu.backend.studyPlan.service.StudyPlanService;
import lombok.NoArgsConstructor;
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
    public ResponseEntity<ResponseBody<StudyPlanResponseDTO>> create(StudyPlanRequestDTO dto, @PathVariable Long studyGroupId) {
        StudyPlanResponseDTO result = studyPlanService.create(dto, studyGroupId);
        ResponseBody<StudyPlanResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.POST_STUDYPLAN_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    // 스터디 계획 조회
    @GetMapping("{studyGroupId}/plan")
    public ResponseEntity<List<StudyPlanResponseDTO>> getAll(){
        return ResponseEntity.ok(studyPlanService.getAll());
    }

    @PatchMapping("{studyGroupId}/plan")
    //스터디 계획서 수정
    public ResponseEntity<ResponseBody<StudyPlanResponseDTO>> updateStudyPlan(UpdateStudyPlanRequestDTO dto, @PathVariable Long studyGroupId){

        //StudyPlanResponseDTO result = studyPlanService.update(dto, studyGroupId);
        StudyPlanResponseDTO updateStudyPlan = studyPlanService.update(dto, studyGroupId);
        ResponseBody<StudyPlanResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.UPDATE_STUDYPLAN_SUCCESS, updateStudyPlan);

        return ResponseEntity.ok(responseBody);
    }

    // 스터디 계획서 삭제
    @DeleteMapping("{studyGroupId}/plan")
    public ResponseEntity<ResponseBody<StudyPlanResponseDTO>> deleteStudyPlan(@PathVariable Long studyGroupId){
        StudyPlanResponseDTO deleteStudyPlan = studyPlanService.delete(studyGroupId);
        ResponseBody<StudyPlanResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.DELETE_STUDYPLAN_SUCCESS, deleteStudyPlan);
        return ResponseEntity.ok(responseBody);
    }
}
