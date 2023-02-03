package com.cbu.backend.studygroup.query.api;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.infra.StudyGroupDao;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("study-groups")
@RequiredArgsConstructor
public class StudyGroupQueryController {

    private final StudyGroupDao studyGroupDao;

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroupResponse> getStudyGroup(@PathVariable StudyGroupNo id) {
        return ResponseEntity.ok(studyGroupDao.findResponseById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyGroupResponse>> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ResponseEntity.ok(studyGroupDao.findAllStudyGroup(pageable));
    }
}
