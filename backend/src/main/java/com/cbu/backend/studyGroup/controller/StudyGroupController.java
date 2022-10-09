package com.cbu.backend.studyGroup.controller;

import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.service.StudyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/study-group")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @GetMapping(params = {"sortby=createdat", "sort=desc"})
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByCreatedAt() {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByCreatedAt());
    }

    @GetMapping(params = {"sortby=journal", "sort=desc"})
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByJournal() {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByJournalsNum());
    }

    @GetMapping(params = {"sortby=like", "sort=desc"})
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByLike() {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByLike());
    }

}
