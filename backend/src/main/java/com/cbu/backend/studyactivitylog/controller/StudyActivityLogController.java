package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyParticipantResponseDTO;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/study-group/{id}")
public class StudyActivityLogController {

    private final StudyActivityLogService studyActivityLogService;

    @PutMapping("/activitylog/{activitylog.id}")
    public ResponseEntity<ResponseFormat<StudyActivityLogResponseDTO>> updateLog(
            @PathVariable Long id,
            @RequestBody StudyActivityLogRequestDTO dto){
        StudyActivityLogResponseDTO updatedLog = studyActivityLogService.update(id,dto);
        ResponseFormat<StudyActivityLogResponseDTO> responseBody = new ResponseFormat<>(ResponseStatus.UPDATE_STUDYACTICITYLOG_SUCCESS, updatedLog);

        return ResponseEntity.ok(responseBody);
    }
}
