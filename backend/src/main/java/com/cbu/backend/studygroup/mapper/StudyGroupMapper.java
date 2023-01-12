package com.cbu.backend.studygroup.mapper;

import com.cbu.backend.domain.member.entity.Member;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupMemberResponse;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.entity.StudyGroupMember;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudyGroupMapper {

    public StudyGroup toEntity(StudyGroupRequest studyGroupRequest) {
        return StudyGroup.builder()
                .name(studyGroupRequest.getName())
                .season(studyGroupRequest.getSeason())
                .description(studyGroupRequest.getDescription())
                .build();
    }

    public StudyGroupResponse toResponse(StudyGroup studyGroup) {
        return StudyGroupResponse.builder()
                .id(studyGroup.getId())
                .studyGroupLeader(
                        toMemberResponse(studyGroup.getStudyGroupLeader().getTeamMember()))
                .studyGroupMembers(toMemberListResponse(studyGroup.getStudyGroupMembers()))
                .description(studyGroup.getDescription())
                .likeCount(studyGroup.getLikeCount())
                .isActive(studyGroup.getIsActive())
                .name(studyGroup.getName())
                .build();
    }

    private StudyGroupMemberResponse toMemberResponse(Member member) {
        return StudyGroupMemberResponse.builder()
                .memberId(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }

    private List<StudyGroupMemberResponse> toMemberListResponse(
            List<StudyGroupMember> studyGroupMembers) {
        return studyGroupMembers.stream()
                .map(StudyGroupMember::getTeamMember)
                .map(this::toMemberResponse)
                .collect(Collectors.toList());
    }
}
