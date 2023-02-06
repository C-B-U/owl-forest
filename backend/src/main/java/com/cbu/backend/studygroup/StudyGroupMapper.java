package com.cbu.backend.studygroup;

import com.cbu.backend.authaccount.command.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.dto.StudyMemberResponse;

import java.util.List;

public class StudyGroupMapper {

    public StudyGroup toEntity(StudyGroupRequest studyGroupRequest) {
        return StudyGroup.builder()
                .name(studyGroupRequest.getName())
                .description(studyGroupRequest.getDescription())
                .build();
    }

    public StudyGroupResponse toResponse(StudyGroup studyGroup) {
        return StudyGroupResponse.builder()
                .name(studyGroup.getName())
                .description(studyGroup.getDescription())
                .leader(toMemberResponse(studyGroup.getLeader()))
                .members(toMemberResponseList(studyGroup))
                .build();
    }

    private List<StudyMemberResponse> toMemberResponseList(StudyGroup studyGroup) {
        return studyGroup.getStudyMembers().stream()
                .map(member -> toMemberResponse(member.getMember()))
                .toList();
    }

    public StudyMemberResponse toMemberResponse(Member member) {
        return StudyMemberResponse.builder()
                .build();
    }
}
