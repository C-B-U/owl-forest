package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-group/{studyGroupId}/studyActivityLog")
@RequiredArgsConstructor
public class StudyActivityLogController {


    private StudyActivityLogService studyActivityLogService;

    @DeleteMapping("{studyActivityLogId}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> deleteStudyActivityLog(
            @PathVariable Long studyGroupId,
            @PathVariable Long studyActivityLogId
    ) {
        StudyActivityLogResponse studyActivityLog = studyActivityLogService.delete(studyGroupId);
        ResponseFormat<StudyActivityLogResponse> responseBody = new ResponseFormat<>(ResponseStatus.DELETE_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> findAllStudyActivityLog(@PathVariable Long studyGroupId) {
        StudyActivityLogResponse studyActivityLog = studyActivityLogService.findAll();
        ResponseFormat<StudyActivityLogResponse> responseBody = new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> create(
            @PathVariable Long studyGroupId,
            @RequestBody StudyActivityLogRequest dto){
        StudyActivityLogResponse createdStudyActivityLog = studyActivityLogService.create(studyGroupId, dto);
        ResponseFormat<StudyActivityLogResponse> responseFormat = new ResponseFormat<>(ResponseStatus.POST_STUDYACTIVITYLOG_SUCCESS, createdStudyActivityLog);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);

    }

    @GetMapping("/{studyActivityLogId}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> findById(@PathVariable Long studyActivityLogId) {
        StudyActivityLogResponse studyActivityLog = studyActivityLogService.findById(studyActivityLogId);
        ResponseFormat<StudyActivityLogResponse> responseFormat = new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);

        return ResponseEntity.ok(responseFormat);
    }
}
