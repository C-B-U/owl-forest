package com.cbu.backend.studygroup;

import com.cbu.backend.config.security.oauth2.LoginUser;
import com.cbu.backend.studygroup.dto.StudyGroupProjection;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("study-groups")
@RequiredArgsConstructor
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @PostMapping
    public ResponseEntity<Long> saveStudyGroup(@RequestBody StudyGroupRequest studyGroupRequest) {
        return ResponseEntity.ok(studyGroupService.saveStudyGroup(studyGroupRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putStudyGroup(
            @PathVariable Long id, @RequestBody StudyGroupRequest studyGroupRequest) {
        studyGroupService.updateStudyGroup(id, studyGroupRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/add")
    public ResponseEntity<Void> addLikeCount(
            @PathVariable Long id, @AuthenticationPrincipal LoginUser loginUser) {
        //        studyGroupService.addLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like-count/cancel")
    public ResponseEntity<Void> cancelLikeCount(
            @PathVariable Long id, @AuthenticationPrincipal LoginUser loginUser) {
        //        studyGroupService.cancelLike(id, loginUser.getAccountId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<Void> finishStudy(@PathVariable Long id) {
        studyGroupService.finishStudy(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyGroup(@PathVariable Long id) {
        studyGroupService.deleteStudyGroup(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroupProjection> getStudyGroup(@PathVariable Long id) {
        return ResponseEntity.ok(studyGroupService.findResponseById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyGroupProjection>> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ResponseEntity.ok(studyGroupService.findAllStudyGroup(pageable));
    }
}
