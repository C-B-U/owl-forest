package com.cbu.backend.studyGroup.entity;

import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.service.StudyGroupService;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum SortValue {
    CREATEDAT("createdat") {
        public Supplier<List<StudyGroupResponseDTO>> of(StudyGroupService studyGroupService) {
            return studyGroupService::searchStudyOrderByCreatedAt;
        }
    },
    JOURNAL("journal") {
        public Supplier<List<StudyGroupResponseDTO>> of(StudyGroupService studyGroupService) {
            return studyGroupService::searchStudyOrderByJournalsNum;
        }
    },
    LIKE("like") {
        public Supplier<List<StudyGroupResponseDTO>> of(StudyGroupService studyGroupService) {
            return studyGroupService::searchStudyOrderByLike;
        }
    };

    private final String value;

    public abstract Supplier<List<StudyGroupResponseDTO>> of(StudyGroupService studyGroupService);

}
