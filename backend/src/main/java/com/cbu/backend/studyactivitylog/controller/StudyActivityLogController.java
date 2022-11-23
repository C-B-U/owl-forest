package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-group/{studyGroupId}/studyActivityLog")
@RequiredArgsConstructor
public class StudyActivityLogController {

    private StudyActivityLogService studyActivityLogService;

    @DeleteMapping("{studyActivityLogId}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> deleteStudyActivityLog(
            @PathVariable Long studyGroupId,
            @PathVariable Long studyActivityLogId
    ) {
        StudyActivityLogResponseDTO studyActivityLog = studyActivityLogService.delete(studyGroupId);
        ResponseFormat<StudyActivityLogResponseDTO> responseBody = new ResponseFormat<>(ResponseStatus.DELETE_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> findAllStudyActivityLog(@PathVariable Long studyGroupId) {
        StudyActivityLogResponseDTO studyActivityLog = studyActivityLogService.findAll();
        ResponseFormat<StudyActivityLogResponseDTO> responseBody = new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);
        return ResponseEntity.ok(responseBody);
    }
}
