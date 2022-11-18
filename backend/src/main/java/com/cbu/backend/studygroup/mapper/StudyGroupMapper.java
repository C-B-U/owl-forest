package com.cbu.backend.studygroup.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.StudyGroup;

@Mapper
public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup mapToEntity(StudyGroupRequest studyGroupRequest) {
        return StudyGroup.builder().build(); // 추후 수정 필요
    }

    public StudyGroupResponse toResponseDTO(StudyGroup studyGroup) {
        return new StudyGroupResponse(); // 추후 수정 필요
    }

}
