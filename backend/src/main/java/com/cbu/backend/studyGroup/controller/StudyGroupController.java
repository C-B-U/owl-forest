package com.cbu.backend.studyGroup.controller;

import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.entity.SortValue;
import com.cbu.backend.studyGroup.service.StudyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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

    @GetMapping
    public ResponseEntity<List<StudyGroupResponseDTO>> findStudy(
            @RequestParam(name = "sortby", defaultValue = "createdat") String sortBy,
            @RequestParam(name = "sort", defaultValue = "desc") String sort) {
        return ResponseEntity.ok(SortValue.valueOf(sortBy).of(studyGroupService).get());
    }

}
