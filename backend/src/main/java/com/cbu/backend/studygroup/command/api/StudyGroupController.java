package com.cbu.backend.studygroup.command.api;

import com.cbu.backend.config.security.oauth2.LoginUser;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.command.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.command.service.StudyGroupService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/study-groups")
@RequiredArgsConstructor
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @PostMapping
    public ResponseEntity<StudyGroupNo> saveStudyGroup(
            @RequestBody StudyGroupRequest studyGroupRequest) {
        return ResponseEntity.ok(studyGroupService.save(studyGroupRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyGroup(
            @PathVariable StudyGroupNo id, @RequestBody StudyGroupRequest studyGroupRequest) {
        studyGroupService.updateStudyGroup(id, studyGroupRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/add")
    public ResponseEntity<Void> addLikeCount(
            @PathVariable StudyGroupNo id, @AuthenticationPrincipal LoginUser loginUser) {
        studyGroupService.addLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/cancel")
    public ResponseEntity<Void> cancelLikeCount(
            @PathVariable StudyGroupNo id, @AuthenticationPrincipal LoginUser loginUser) {
        studyGroupService.cancelLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<Void> finishStudy(@PathVariable StudyGroupNo id) {
        studyGroupService.finishStudy(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyGroup(@PathVariable StudyGroupNo id) {
        studyGroupService.deleteStudyGroup(id);
        return ResponseEntity.ok().build();
    }
}
