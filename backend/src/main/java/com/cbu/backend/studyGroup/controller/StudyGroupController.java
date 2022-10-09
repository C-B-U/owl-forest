package com.cbu.backend.studyGroup.controller;

import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.entity.SortDirection;
import com.cbu.backend.studyGroup.service.StudyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/study-group")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @GetMapping(params = "sortby=createdat")
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByCreatedAt(
            @RequestParam(name = "sort") SortDirection sort) {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByCreatedAt(sort.getSortClassifier()));
    }

    @GetMapping(params = "sortby=journal")
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByJournal(
            @RequestParam(name = "sort") SortDirection sort) {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByJournalsNum(sort.getSortClassifier()));
    }

    @GetMapping(params = "sortby=like")
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudyGroupSortByLike(
            @RequestParam(name = "sort") SortDirection sort) {
        return ResponseEntity.ok(studyGroupService.searchStudyOrderByLike(sort.getSortClassifier()));
    }

}
