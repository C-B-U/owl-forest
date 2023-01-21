package com.cbu.backend.studycrew.query.api;

import com.cbu.backend.studycrew.command.domain.SortDirection;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.query.dto.StudyCrewResponse;
import com.cbu.backend.studycrew.query.service.StudyCrewQueryService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-crews")
@RequiredArgsConstructor
public class StudyCrewQueryController {

    private final StudyCrewQueryService studyCrewQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<StudyCrewResponse> getStudyCrew(@PathVariable StudyCrewNo id) {
        return ResponseEntity.ok(studyCrewQueryService.getStudyCrew(id));
    }

    @GetMapping(params = "sortby=createdat")
    public ResponseEntity<List<StudyCrewResponse>> getStudyCrewSortByCreatedAt(
            @RequestParam(name = "sort") SortDirection sort, Pageable pageable) {
        return ResponseEntity.ok(studyCrewQueryService.getStudyCrewSortByCreatedAt(sort, pageable));
    }

    @GetMapping(params = "sortby=likecount")
    public ResponseEntity<List<StudyCrewResponse>> getStudyCrewSortByLikeCount(
            @RequestParam(name = "sort") SortDirection sort, Pageable pageable) {
        return ResponseEntity.ok(studyCrewQueryService.getStudyCrewSortByLikeCount(sort, pageable));
    }
}
