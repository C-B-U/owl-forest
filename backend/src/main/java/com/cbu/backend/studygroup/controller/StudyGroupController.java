package com.cbu.backend.studygroup.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.SortDirection;
import com.cbu.backend.studygroup.service.StudyGroupService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/study-group")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @PostMapping
    public ResponseEntity<ResponseFormat<StudyGroupResponse>> create(StudyGroupRequest dto) {
        StudyGroupResponse createdStudyGroup = studyGroupService.registerStudyGroup(dto);
        ResponseFormat<StudyGroupResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.POST_STUDYGROUP_SUCCESS, createdStudyGroup);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<StudyGroupResponse>> findById(@PathVariable Long id) {
        StudyGroupResponse studyGroup = studyGroupService.searchById(id);
        ResponseFormat<StudyGroupResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_SUCCESS, studyGroup);

        return ResponseEntity.ok(responseFormat);
    }

    @PatchMapping("/{id}/likecount")
    public ResponseEntity<ResponseFormat<Void>> modifyUpdateCount(
            @PathVariable Long id, Integer likeCount) {
        studyGroupService.updateLikeCount(id, likeCount);
        ResponseFormat<Void> responseFormat =
                new ResponseFormat<>(ResponseStatus.PATCH_STUDYGROUP_LIKECOUNT_SUCCESS);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "sortby=createdat")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>> findStudyGroupSortByCreatedAt(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponse> studyGroupList =
                studyGroupService.searchStudyOrderByCreatedAt(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponse>> responseFormat =
                new ResponseFormat<>(
                        ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_CREATEDAT_SUCCESS,
                        studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "sortby=studyactivitylog")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>>
            findStudyGroupSortByStudyActivityLog(@RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponse> studyGroupList =
                studyGroupService.searchStudyOrderByStudyActivityLog(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponse>> responseFormat =
                new ResponseFormat<>(
                        ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_STUDYACTIVITYLOG_SUCCESS,
                        studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "sortby=likecount")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>> findStudyGroupSortByLike(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponse> studyGroupList =
                studyGroupService.searchStudyOrderByLikeCount(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponse>> responseFormat =
                new ResponseFormat<>(
                        ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_LIKECOUNT_SUCCESS,
                        studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }
}
