package com.cbu.backend.studycrew.query.service;

import com.cbu.backend.studycrew.command.domain.SortDirection;
import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.query.dto.StudyCrewResponse;
import com.cbu.backend.studycrew.query.infra.StudyCrewQueryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class StudyCrewQueryService {

    private final StudyCrewQueryRepository studyCrewQueryRepository;

    public StudyCrewResponse getStudyCrew(StudyCrewNo id) {
        return new StudyCrewResponse(studyCrewQueryRepository.getStudyCrew(id));
    }

    public List<StudyCrewResponse> getStudyCrewSortByCreatedAt(
            SortDirection sortDirection, Pageable pageable) {
        return getStudyCrewList(
                studyCrewQueryRepository::getStudyCrewSortByCreatedAt, sortDirection, pageable);
    }

    public List<StudyCrewResponse> getStudyCrewSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return getStudyCrewList(
                studyCrewQueryRepository::getStudyCrewSortByLikeCount, sortDirection, pageable);
    }

    private List<StudyCrewResponse> getStudyCrewList(
            BiFunction<SortDirection, Pageable, List<StudyCrew>> function,
            SortDirection sortDirection,
            Pageable pageable) {
        return function.apply(sortDirection, pageable).stream()
                .map(StudyCrewResponse::new)
                .toList();
    }
}
