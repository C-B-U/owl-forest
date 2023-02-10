package com.cbu.backend.studyplan;

import com.cbu.backend.studyplan.dto.StudyPlanIdResponse;
import com.cbu.backend.studyplan.dto.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.StudyPlanResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("study-plans")
public class StudyPlanController {
    private final StudyPlanService studyPlanService;

    @PostMapping
    public ResponseEntity<StudyPlanIdResponse> saveStudyPlan(
            @RequestBody StudyPlanRequest studyPlanRequest) {
        return ResponseEntity.ok(studyPlanService.saveStudyPlan(studyPlanRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyPlan(
            @PathVariable Long id, @RequestBody StudyPlanRequest studyPlanRequest) {
        studyPlanService.updateStudyPlan(id, studyPlanRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyPlan(@PathVariable Long id) {
        studyPlanService.deleteStudyPlan(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyPlanResponse> getStudyPlan(@PathVariable Long id) {
        return ResponseEntity.ok(studyPlanService.findStudyPlan(id));
    }
}
