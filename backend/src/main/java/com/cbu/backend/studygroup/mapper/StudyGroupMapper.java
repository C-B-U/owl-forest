package com.cbu.backend.studygroup.mapper;

import com.cbu.backend.studygroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studygroup.entity.StudyGroup;

public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup mapToEntity(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) {
        return StudyGroup.builder().build(); // TODO 스터디 그룹 생성
    }

    public StudyGroupResponseDTO toResponseDTO(StudyGroup studyGroup) {
        return new StudyGroupResponseDTO(); // TODO 스터디 그룹 Response DTO 생성
    }

}
