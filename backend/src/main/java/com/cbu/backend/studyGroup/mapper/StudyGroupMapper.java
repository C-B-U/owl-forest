package com.cbu.backend.studyGroup.mapper;

import com.cbu.backend.studyGroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studyGroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studyGroup.entity.StudyGroup;

public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup mapToEntity(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) {
        return StudyGroup.builder().build(); // TODO 스터디 그룹 생성
    }

    public StudyGroupResponseDTO toResponseDTO(StudyGroup studyGroup) {
        return new StudyGroupResponseDTO(); // TODO 스터디 그룹 Response DTO 생성
    }

}
