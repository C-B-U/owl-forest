package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-group/{studyGroupId}/studyActivityLog")
@RequiredArgsConstructor
public class StudyActivityLogController {
    private final StudyActivityLogService studyActivityLogService;

    @PostMapping
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> createStudyActivityLog(
            @PathVariable Long studyGroupId,
            @RequestBody StudyActivityLogRequestDTO dto){
        StudyActivityLogResponseDTO createdStudyActivityLog = studyActivityLogService.registerStudyActivityLog(studyGroupId, dto);
        ResponseFormat<StudyActivityLogResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.POST_STUDYACTIVITYLOG_SUCCESS, createdStudyActivityLog);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);

    }

    @GetMapping("/{studyActivityLogId}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> findById(@PathVariable Long studyActivityLogId) {
        StudyActivityLogResponseDTO studyActivityLog = studyActivityLogService.searchById(studyActivityLogId);
        ResponseFormat<StudyActivityLogResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);

        return ResponseEntity.ok(responseFormat);
    }
}
