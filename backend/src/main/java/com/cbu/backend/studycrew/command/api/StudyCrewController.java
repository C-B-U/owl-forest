package com.cbu.backend.studycrew.command.api;

import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import com.cbu.backend.studycrew.command.dto.StudyCrewResponse;
import com.cbu.backend.studycrew.command.service.StudyCrewService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StudyCrewResponse> putStudyCrew(
            @PathVariable StudyCrewNo id, @RequestBody StudyCrewRequest studyCrewRequest) {
        return ResponseEntity.ok(studyCrewService.updateStudyCrew(id, studyCrewRequest));
    }

    @PatchMapping("/{id}/like-count/add")
    public ResponseEntity<Void> patchAddLikeCount(@PathVariable StudyCrewNo id) {
        studyCrewService.addLike(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}/like-count/cancel")
    public ResponseEntity<Void> patchCancelLikeCount(@PathVariable StudyCrewNo id) {
        studyCrewService.cancelLike(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}/finish")
    public ResponseEntity<Void> patchFinishStudyCrew(@PathVariable StudyCrewNo id) {
        studyCrewService.finishStudyCrew(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyCrew(@PathVariable StudyCrewNo id) {
        studyCrewService.deleteStudyCrew(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
