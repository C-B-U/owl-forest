package com.cbu.backend.studygroup;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;

import com.cbu.backend.studygroup.dto.StudyMemberResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudyGroupMapper {
    @Mapping(target = "name", source = "studyGroupRequest.name")
    @Mapping(target = "leader", source = "leader")
    StudyGroup toEntity(
            StudyGroupRequest studyGroupRequest, Member leader, List<Member> studyMembers);

    @Mapping(target = "likeCount", expression = "java(studyGroup.getLikeMember().size())")
    @Mapping(target = "members", source = "studyMembers")
    StudyGroupResponse toResponse(StudyGroup studyGroup);

    @IterableMapping(elementTargetType = StudyMemberResponse.class)
    Set<StudyMemberResponse> map(Set<StudyMember> studyMembers);
    @Mapping(target = "id", source = "studyMember.member.id")
    @Mapping(target = "name", source = "studyMember.member.name")
    StudyMemberResponse map(StudyMember studyMember);
}
