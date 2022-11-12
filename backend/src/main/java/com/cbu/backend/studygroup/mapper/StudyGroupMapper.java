package com.cbu.backend.studygroup.mapper;

import com.cbu.backend.studygroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studygroup.entity.StudyGroup;
import org.springframework.stereotype.Component;

@Component
public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup mapToEntity(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) {
        return StudyGroup.builder().build(); // 추후 수정 필요
    }

    public StudyGroupResponseDTO toResponseDTO(StudyGroup studyGroup) {
        return new StudyGroupResponseDTO(); // 추후 수정 필요
    }

}
