package com.cbu.backend.studycrew.command.api;

import com.cbu.backend.config.security.oauth2.LoginUser;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import com.cbu.backend.studycrew.command.service.StudyCrewService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/study-crews")
@RequiredArgsConstructor
public class StudyCrewController {

    private final StudyCrewService studyCrewService;

    @PostMapping
    public ResponseEntity<StudyCrewNo> saveStudyCrew(
            @RequestBody StudyCrewRequest studyCrewRequest) {
        return ResponseEntity.ok(studyCrewService.save(studyCrewRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyCrew(
            @PathVariable StudyCrewNo id, @RequestBody StudyCrewRequest studyCrewRequest) {
        studyCrewService.updateStudyCrew(id, studyCrewRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/add")
    public ResponseEntity<Void> addLikeCount(
            @PathVariable StudyCrewNo id, @AuthenticationPrincipal LoginUser loginUser) {
        studyCrewService.addLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/cancel")
    public ResponseEntity<Void> cancelLikeCount(
            @PathVariable StudyCrewNo id, @AuthenticationPrincipal LoginUser loginUser) {
        studyCrewService.cancelLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<Void> finishStudyCrew(@PathVariable StudyCrewNo id) {
        studyCrewService.finishStudyCrew(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyCrew(@PathVariable StudyCrewNo id) {
        studyCrewService.deleteStudyCrew(id);
        return ResponseEntity.ok().build();
    }
}
