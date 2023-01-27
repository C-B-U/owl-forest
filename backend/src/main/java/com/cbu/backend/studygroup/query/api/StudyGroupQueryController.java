package com.cbu.backend.studygroup.query.api;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.service.StudyGroupQueryService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-groups")
@RequiredArgsConstructor
public class StudyGroupQueryController {

    private final StudyGroupQueryService studyGroupQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroupResponse> getStudyGroup(@PathVariable StudyGroupNo id) {
        return ResponseEntity.ok(studyGroupQueryService.getStudyGroup(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyGroupResponse>> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ResponseEntity.ok(studyGroupQueryService.getAllStudyGroup(pageable));
    }
}
