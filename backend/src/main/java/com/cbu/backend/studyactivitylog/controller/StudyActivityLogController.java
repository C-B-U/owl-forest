package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/study-group/{id}/journal")
@RequiredArgsConstructor
public class StudyActivityLogController {

    private StudyActivityLogService studyActivityLogService;

    @DeleteMapping("{journalId}}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> deleteStudyActivityLog(
            @PathVariable Long id,
            @PathVariable Long journalId
    ) {
        StudyActivityLogResponseDTO deleteStudyActivityLog = studyActivityLogService.delete(journalId);
        ResponseFormat<StudyActivityLogResponseDTO> responseBody = new ResponseFormat<>(ResponseStatus.DELETE_STUDYACTIVITYLOG_SUCCESS, deleteStudyActivityLog);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> getAllStudyActivityLog(@PathVariable Long id) {
        StudyActivityLogResponseDTO getAllStudyActivityLog = studyActivityLogService.getAll();
        ResponseFormat<StudyActivityLogResponseDTO> responseBody = new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, getAllStudyActivityLog);
        return ResponseEntity.ok(responseBody);
    }
}
