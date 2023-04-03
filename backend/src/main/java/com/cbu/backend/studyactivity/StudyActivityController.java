package com.cbu.backend.studyactivity;

import com.cbu.backend.global.IdResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("study-activities")
@RequiredArgsConstructor
public class StudyActivityController {

    private final StudyActivityService studyActivityService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> saveStudyActivity(
            @RequestBody @Valid StudyActivityRequest studyActivityRequest) {
        return ResponseEntity.ok(studyActivityService.saveStudyActivity(studyActivityRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyActivity(
            @PathVariable Long id, @RequestBody @Valid StudyActivityRequest studyActivityRequest) {
        studyActivityService.updateStudyActivity(id, studyActivityRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyActivity(@PathVariable Long id) {
        studyActivityService.deleteStudyActivity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyActivityResponse> getStudyActivity(@PathVariable Long id) {
        return ResponseEntity.ok(studyActivityService.findStudyActivity(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyActivityResponse>> getStudyActivityList(
            @RequestParam Long studyGroup) {
        return ResponseEntity.ok(
                studyActivityService.findStudyActivityListByStudyGroupId(studyGroup));
    }
}
