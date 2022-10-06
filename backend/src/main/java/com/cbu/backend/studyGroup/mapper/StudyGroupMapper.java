package com.cbu.backend.studyGroup.mapper;

import com.cbu.backend.studyGroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.entity.StudyGroup;

public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup toEntity(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) {
        return StudyGroup.builder().build(); // 추후 수정 필요
    }

    public StudyGroupResponseDTO toResponseDTO(StudyGroup studyGroup) {
        return new StudyGroupResponseDTO(); // 추후 수정 필요
    }

}
