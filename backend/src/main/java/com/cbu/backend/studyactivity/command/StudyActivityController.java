package com.cbu.backend.studyactivity.command;

import com.cbu.backend.studyactivity.command.dto.StudyActivityRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("study-activities")
@RequiredArgsConstructor
public class StudyActivityController {

    private final StudyActivityService studyActivityService;

    @PostMapping
    public ResponseEntity<Long> saveStudyActivity(
            @RequestBody StudyActivityRequest studyActivityRequest) {
        return ResponseEntity.ok(studyActivityService.saveStudyActivity(studyActivityRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyActivity(
            @PathVariable Long id, @RequestBody StudyActivityRequest studyActivityRequest) {
        studyActivityService.updateStudyActivity(id, studyActivityRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyActivity(@PathVariable Long id) {
        studyActivityService.deleteStudyActivity(id);
        return ResponseEntity.ok().build();
    }
}
