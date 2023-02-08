package com.cbu.backend.studyactivity;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studyactivity.dto.ActivityMemberResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;

import com.cbu.backend.studygroup.StudyMember;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudyActivityMapper {
    @Mapping(target = "activityMembers", source = "activityMembers")
    @Mapping(target = "description", source = "studyActivityRequest.description")
    StudyActivity toEntity(
            StudyActivityRequest studyActivityRequest, List<Member> activityMembers);

    @Mapping(target = "activityMembers", source = "studyActivity.activityMembers")
    StudyActivityResponse toResponse(StudyActivity studyActivity);

    @IterableMapping(elementTargetType = ActivityMemberResponse.class)
    List<ActivityMemberResponse> map(Set<StudyMember> activityMembers);

    @Mapping(target = "id", source = "activityMembers.member.id")
    @Mapping(target = "name", source = "activityMembers.member.name")
    ActivityMemberResponse map(StudyMember activityMembers);
}
