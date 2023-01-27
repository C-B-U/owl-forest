package com.cbu.backend.studygroup.query.service;

import com.cbu.backend.studygroup.command.domain.SortDirection;
import com.cbu.backend.studygroup.command.domain.StudyGroup;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.infra.StudyGroupDao;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class StudyGroupQueryService {

    private final StudyGroupDao studyGroupDao;

    public StudyGroupResponse getStudyGroup(StudyGroupNo id) {
        return new StudyGroupResponse(studyGroupDao.findStudyGroup(id));
    }

    public List<StudyGroupResponse> getStudyGroupSortByCreatedAt(
            SortDirection sortDirection, Pageable pageable) {
        return getStudyGroupList(
                studyGroupDao::findStudyGroupSortByCreatedAt, sortDirection, pageable);
    }

    public List<StudyGroupResponse> getStudyGroupSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return getStudyGroupList(
                studyGroupDao::findStudyGroupSortByLikeCount, sortDirection, pageable);
    }

    private List<StudyGroupResponse> getStudyGroupList(
            BiFunction<SortDirection, Pageable, List<StudyGroup>> function,
            SortDirection sortDirection,
            Pageable pageable) {
        return function.apply(sortDirection, pageable).stream()
                .map(StudyGroupResponse::new)
                .toList();
    }
}
