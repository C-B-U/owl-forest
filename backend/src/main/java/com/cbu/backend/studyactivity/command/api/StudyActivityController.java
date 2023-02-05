package com.cbu.backend.studyactivity.command.api;

import com.cbu.backend.studyactivity.command.domain.StudyActivityNo;
import com.cbu.backend.studyactivity.command.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.command.service.StudyActivityService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("study-activities")
@RequiredArgsConstructor
public class StudyActivityController {

    private final StudyActivityService studyActivityService;

    @PostMapping
    public ResponseEntity<StudyActivityNo> saveStudyActivity(
            @RequestBody StudyActivityRequest studyActivityRequest) {
        return ResponseEntity.ok(studyActivityService.saveStudyActivity(studyActivityRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyActivity(
            @PathVariable StudyActivityNo id,
            @RequestBody StudyActivityRequest studyActivityRequest) {
        studyActivityService.updateStudyActivity(id, studyActivityRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyActivity(@PathVariable StudyActivityNo id) {
        studyActivityService.deleteStudyActivity(id);
        return ResponseEntity.ok().build();
    }
}
