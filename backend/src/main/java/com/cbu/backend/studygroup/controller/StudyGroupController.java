package com.cbu.backend.studygroup.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studygroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponseDTO;
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
    public ResponseEntity<ResponseFormat<StudyGroupResponseDTO>> createStudyGroup(CreateStudyGroupRequestDTO dto) {
        StudyGroupResponseDTO createdStudyGroup = studyGroupService.registerStudyGroup(dto);
        ResponseFormat<StudyGroupResponseDTO> responseFormat
                = new ResponseFormat<>(ResponseStatus.POST_STUDYGROUP_SUCCESS, createdStudyGroup);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<StudyGroupResponseDTO>> findById(@PathVariable Long id) {
        StudyGroupResponseDTO studyGroup = studyGroupService.searchById(id);
        ResponseFormat<StudyGroupResponseDTO> responseFormat
                = new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_SUCCESS, studyGroup);

        return ResponseEntity.ok(responseFormat);
    }

    @PatchMapping("/{id}/likecount")
    public ResponseEntity<ResponseFormat<Void>> modifyUpdateCount(@PathVariable Long id, Integer likeCount) {
        studyGroupService.updateLikeCount(id, likeCount);
        ResponseFormat<Void> responseFormat = new ResponseFormat<>(ResponseStatus.PATCH_STUDYGROUP_LIKECOUNT_SUCCESS);

        return ResponseEntity.ok(responseFormat);
    }


    @GetMapping(params = "sortby=createdat")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponseDTO>>> findStudyGroupSortByCreatedAt(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByCreatedAt(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponseDTO>> responseFormat
                = new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_CREATEDAT_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "sortby=studyactivitylog")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponseDTO>>> findStudyGroupSortByStudyActivityLog(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByStudyActivityLog(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponseDTO>> responseFormat
                = new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_STUDYACTIVITYLOG_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "sortby=likecount")
    public ResponseEntity<ResponseFormat<List<StudyGroupResponseDTO>>> findStudyGroupSortByLike(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByLikeCount(sort.getSortClassifier());
        ResponseFormat<List<StudyGroupResponseDTO>> responseFormat
                = new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_LIKECOUNT_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseFormat);
    }

}
