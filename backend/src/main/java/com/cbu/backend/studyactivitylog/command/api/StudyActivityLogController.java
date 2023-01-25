package com.cbu.backend.studyactivitylog.command.api;

import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLogNo;
import com.cbu.backend.studyactivitylog.command.dto.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.command.service.StudyActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-activity-logs")
@RequiredArgsConstructor
public class StudyActivityLogController {

    private final StudyActivityLogService studyActivityLogService;

    @PostMapping
    public ResponseEntity<StudyActivityLogNo> saveStudyActivityLog(
            @RequestBody StudyActivityLogRequest studyActivityLogRequest) {
        return ResponseEntity.ok(studyActivityLogService.saveStudyActivityLog(studyActivityLogRequest));
    }
}
