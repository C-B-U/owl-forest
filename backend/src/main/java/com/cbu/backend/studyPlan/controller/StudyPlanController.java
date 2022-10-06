package com.cbu.backend.studyPlan.controller;

import com.cbu.backend.studyPlan.dto.request.StudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.response.StudyPlanResponseDTO;
import com.cbu.backend.studyPlan.service.StudyPlanService;
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
    public ResponseEntity<StudyPlanResponseDTO> createStudyPlan(StudyPlanRequestDTO dto, @PathVariable Long studyGroupId) {

        StudyPlanResponseDTO result = studyPlanService.create(dto, studyGroupId);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //스터디 계획서 조회
    @PutMapping("{studyGroupId}/plan")
    public ResponseEntity<StudyPlanResponseDTO> getByStudyGroupId(StudyPlanRequestDTO dto, @PathVariable Long studyGroupId) {

        StudyPlanResponseDTO result = studyPlanService.getByStudyGroupId(dto, studyGroupId);

        return  ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("{studyGroupId}/plan")
    //스터디 계획서 수정
    public ResponseEntity<StudyPlanResponseDTO> updateStudyPlan(StudyPlanRequestDTO dto, @PathVariable Long studyGroupId){

        StudyPlanResponseDTO result = studyPlanService.update(dto, studyGroupId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("{studyGroupId}/plan")
    //스터디 계획서 삭제
    public ResponseEntity<Void> deleteStudyplan(StudyPlanRequestDTO dto, @PathVariable Long studyGroupId){

        StudyPlanResponseDTO result = studyPlanService.delete(dto, studyGroupId);

        return ResponseEntity.status()
    }
}
