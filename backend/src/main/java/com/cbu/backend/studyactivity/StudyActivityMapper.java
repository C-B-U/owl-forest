package com.cbu.backend.studyactivity;

import com.cbu.backend.studyactivity.dto.ActivityMemberResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;
import com.cbu.backend.studyactivity.dto.StudyTimeResponse;
import com.cbu.backend.studygroup.StudyMember;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudyActivityMapper {
    @Mapping(target = "activityMembers", source = "activityMembers")
    StudyActivity toEntity(
            StudyActivityRequest studyActivityRequest, Set<StudyMember> activityMembers);

    @Mapping(target = "activityMembers", source = "studyActivity.activityMembers")
    StudyActivityResponse toResponse(StudyActivity studyActivity);

    @IterableMapping(elementTargetType = ActivityMemberResponse.class)
    Set<ActivityMemberResponse> map(Set<StudyMember> studyParticipants);

    @Mapping(target = "id", source = "studyParticipant.member.id")
    @Mapping(target = "name", source = "studyParticipant.member.name")
    ActivityMemberResponse map(StudyMember studyParticipant);

    default StudyTimeResponse map(StudyTime studyTime) {
        return new StudyTimeResponse(studyTime);
    }
}
