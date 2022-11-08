package com.cbu.backend.studygroup.controller;

import com.cbu.backend.global.ResponseBody;
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
    public ResponseEntity<ResponseBody<StudyGroupResponseDTO>> createStudyGroup(CreateStudyGroupRequestDTO dto) {
        StudyGroupResponseDTO createdStudyGroup = studyGroupService.registerStudyGroup(dto);
        ResponseBody<StudyGroupResponseDTO> responseBody
                = new ResponseBody<>(ResponseStatus.POST_STUDYGROUP_SUCCESS, createdStudyGroup);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @GetMapping(params = "sortby=createdat")
    public ResponseEntity<ResponseBody<List<StudyGroupResponseDTO>>> findStudyGroupSortByCreatedAt(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByCreatedAt(sort.getSortClassifier());
        ResponseBody<List<StudyGroupResponseDTO>> responseBody
                = new ResponseBody<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_CREATEDAT_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(params = "sortby=activitylog")
    public ResponseEntity<ResponseBody<List<StudyGroupResponseDTO>>> findStudyGroupSortByStudyActivityLogs(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByStudyActivityLog(sort.getSortClassifier());
        ResponseBody<List<StudyGroupResponseDTO>> responseBody
                = new ResponseBody<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_STUDYACTIVITYLOG_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(params = "sortby=likecount")
    public ResponseEntity<ResponseBody<List<StudyGroupResponseDTO>>> findStudyGroupSortByLike(
            @RequestParam(name = "sort") SortDirection sort) {
        List<StudyGroupResponseDTO> studyGroupList
                = studyGroupService.searchStudyOrderByLikeCount(sort.getSortClassifier());
        ResponseBody<List<StudyGroupResponseDTO>> responseBody
                = new ResponseBody<>(ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_LIKE_SUCCESS, studyGroupList);

        return ResponseEntity.ok(responseBody);
    }

}
