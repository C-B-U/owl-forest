package com.cbu.backend.studycrew.command.api;

import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import com.cbu.backend.studycrew.command.dto.StudyCrewResponse;
import com.cbu.backend.studycrew.command.service.StudyCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/study-crew")
@RequiredArgsConstructor
public class StudyCrewController {

    private final StudyCrewService studyCrewService;


    @PostMapping
    public ResponseEntity<StudyCrewResponse> save(@RequestBody StudyCrewRequest studyCrewRequest) {
        return ResponseEntity.ok(studyCrewService.save(studyCrewRequest));
    }
}
