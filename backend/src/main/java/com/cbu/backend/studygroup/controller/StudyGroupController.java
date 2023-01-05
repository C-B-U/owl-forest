package com.cbu.backend.studygroup.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.SortDirection;
import com.cbu.backend.studygroup.service.StudyGroupService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 스터디 그룹 요청을 처리하는 API Controller
 *
 * @author ohksj77(김승진)
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/study-group")
public class StudyGroupController {

  private final StudyGroupService studyGroupService;

  /** 스터디 그룹 생성 API */
  @PostMapping
  public ResponseEntity<ResponseFormat<StudyGroupResponse>> create(StudyGroupRequest dto) {
    StudyGroupResponse createdStudyGroup = studyGroupService.createStudyGroup(dto);
    ResponseFormat<StudyGroupResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.POST_STUDYGROUP_SUCCESS, createdStudyGroup);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
  }

  /** 스터디 그룹 조회 API */
  @GetMapping("/{id}")
  public ResponseEntity<ResponseFormat<StudyGroupResponse>> findById(@PathVariable Long id) {
    StudyGroupResponse studyGroup = studyGroupService.findById(id);
    ResponseFormat<StudyGroupResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.GET_STUDYGROUP_SUCCESS, studyGroup);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 좋아요 업데이트 API */
  @PatchMapping("/{id}/likecount")
  public ResponseEntity<ResponseFormat<Void>> updateLikeCount(
      @PathVariable Long id, Integer likeCount) {
    studyGroupService.updateLikeCount(id, likeCount);
    ResponseFormat<Void> responseFormat =
        new ResponseFormat<>(ResponseStatus.PATCH_STUDYGROUP_LIKECOUNT_SUCCESS);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 생성시간순 전체 조회 API */
  @GetMapping(params = "sortby=createdat")
  public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>> findStudyGroupSortByCreatedAt(
      @RequestParam(name = "sort") SortDirection sort) {
    List<StudyGroupResponse> studyGroupList =
        studyGroupService.findStudyGroupSortByCreatedAt(sort.getSortClassifier());
    ResponseFormat<List<StudyGroupResponse>> responseFormat =
        new ResponseFormat<>(
            ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_CREATEDAT_SUCCESS, studyGroupList);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 일지 개수순 전체 조회 API */
  @GetMapping(params = "sortby=studyactivitylog")
  public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>>
      findStudyGroupSortByStudyActivityLog(@RequestParam(name = "sort") SortDirection sort) {
    List<StudyGroupResponse> studyGroupList =
        studyGroupService.findStudyGroupSortByStudyActivityLog(sort.getSortClassifier());
    ResponseFormat<List<StudyGroupResponse>> responseFormat =
        new ResponseFormat<>(
            ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_STUDYACTIVITYLOG_SUCCESS, studyGroupList);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 좋아요 갯수순 전체 조회 API */
  @GetMapping(params = "sortby=likecount")
  public ResponseEntity<ResponseFormat<List<StudyGroupResponse>>> findStudyGroupSortByLikeCount(
      @RequestParam(name = "sort") SortDirection sort) {
    List<StudyGroupResponse> studyGroupList =
        studyGroupService.findStudyGroupSortByLikeCount(sort.getSortClassifier());
    ResponseFormat<List<StudyGroupResponse>> responseFormat =
        new ResponseFormat<>(
            ResponseStatus.GET_STUDYGROUP_LIST_SORTBY_LIKECOUNT_SUCCESS, studyGroupList);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 업데이트 API */
  @PutMapping("/{id}")
  public ResponseEntity<ResponseFormat<StudyGroupResponse>> updateStudyGroup(
      @PathVariable Long id, StudyGroupRequest dto) {
    StudyGroupResponse studyGroup = studyGroupService.updateStudyGroup(id, dto);
    ResponseFormat<StudyGroupResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.PUT_STUDYGROUP_SUCCESS, studyGroup);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 마감 (활동 종료) API */
  @PatchMapping("{id}/finish")
  public ResponseEntity<ResponseFormat<Void>> finishStudyGroup(@PathVariable Long id) {
    studyGroupService.finishStudyGroup(id);
    ResponseFormat<Void> responseFormat =
        new ResponseFormat<>(ResponseStatus.PATCH_STUDYGROUP_FINISH_SUCCESS);

    return ResponseEntity.ok(responseFormat);
  }

  /** 스터디 그룹 삭제 API */
  @DeleteMapping("{id}")
  public ResponseEntity<ResponseFormat<StudyGroupResponse>> deleteStudyGroup(
      @PathVariable Long id) {
    StudyGroupResponse studyGroupResponse = studyGroupService.deleteStudyGroup(id);
    ResponseFormat<StudyGroupResponse> responseFormat =
        new ResponseFormat<>(ResponseStatus.DELETE_STUDYGROUP_SUCCESS, studyGroupResponse);

    return ResponseEntity.ok(responseFormat);
  }
}
