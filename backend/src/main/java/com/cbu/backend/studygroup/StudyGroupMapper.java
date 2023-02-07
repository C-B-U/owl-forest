package com.cbu.backend.studygroup;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StudyGroupMapper {
    @Mapping(target = "name", source = "studyGroupRequest.name")
    @Mapping(target = "leader", source = "leader")
    StudyGroup toEntity(
            StudyGroupRequest studyGroupRequest, Member leader, List<Member> studyMembers);

    @Mapping(target = "likeCount", expression = "java(studyGroup.getLikeCount().size())")
    StudyGroupResponse toResponse(StudyGroup studyGroup);
}
