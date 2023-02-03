package com.cbu.backend.studyactivitylog.command.api;

import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLogNo;
import com.cbu.backend.studyactivitylog.command.dto.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.command.service.StudyActivityLogService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("study-activity-logs")
@RequiredArgsConstructor
public class StudyActivityLogController {

    private final StudyActivityLogService studyActivityLogService;

    @PostMapping
    public ResponseEntity<StudyActivityLogNo> saveStudyActivityLog(
            @RequestBody StudyActivityLogRequest studyActivityLogRequest) {
        return ResponseEntity.ok(
                studyActivityLogService.saveStudyActivityLog(studyActivityLogRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyActivityLog(
            @PathVariable StudyActivityLogNo id,
            @RequestBody StudyActivityLogRequest studyActivityLogRequest) {
        studyActivityLogService.updateStudyActivityLog(id, studyActivityLogRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyActivityLog(@PathVariable StudyActivityLogNo id) {
        studyActivityLogService.deleteStudyActivityLog(id);
        return ResponseEntity.ok().build();
    }
}
