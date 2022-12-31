package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponse;
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
  public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> create(
      @PathVariable Long studyGroupId, @RequestBody StudyActivityLogRequest dto) {
    StudyActivityLogResponse createdStudyActivityLog =
        studyActivityLogService.create(studyGroupId, dto);
    ResponseFormat<StudyActivityLogResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.POST_STUDYACTIVITYLOG_SUCCESS, createdStudyActivityLog);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
  }

  @GetMapping("/{studyActivityLogId}")
  public ResponseEntity<ResponseFormat<StudyActivityLogResponse>> findById(
      @PathVariable Long studyActivityLogId) {
    StudyActivityLogResponse studyActivityLog =
        studyActivityLogService.findById(studyActivityLogId);
    ResponseFormat<StudyActivityLogResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.GET_STUDYACTIVITYLOG_SUCCESS, studyActivityLog);

    return ResponseEntity.ok(responseFormat);
  }
}
