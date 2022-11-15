package com.cbu.backend.studyactivitylog.controller;

import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.global.ResponseBody;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/study-group/{id}/journal")
@RequiredArgsConstructor
public class StudyActivityLogController {

    private StudyActivityLogService studyActivityLogService;

    @DeleteMapping("{journalId}}")
    public ResponseEntity<ResponseBody<StudyActivityLogResponseDTO>> deleteStudyActivityLog(
            @PathVariable Long id,
            @PathVariable Long journalId
    ) {
        StudyActivityLogResponseDTO deleteStudyActivityLog = studyActivityLogService.delete(journalId);
//        ResponseBody<StudyActivityLogResponseDTO> = new ResponseBody<>();
//        return ResponseEntity.ok(responseBody);
    }

//    @GetMapping
//    public ResponseEntity<?> getAllStudyActivityLog() {
//
//    }

}
