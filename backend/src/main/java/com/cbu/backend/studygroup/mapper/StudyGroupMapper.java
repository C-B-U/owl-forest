package com.cbu.backend.studygroup.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupMemberResponse;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.entity.StudyGroupMember;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class StudyGroupMapper { // 덤프 클래스입니다.

    public StudyGroup mapToEntity(StudyGroupRequest studyGroupRequest) {
        return StudyGroup.builder()
                .name(studyGroupRequest.getName())
                .season(studyGroupRequest.getSeason())
                .summary(studyGroupRequest.getSummary())
                .build(); // 추후 수정 필요
    }
    public StudyGroupResponse toResponse(StudyGroup studyGroup) {
        return StudyGroupResponse.builder()
                .studyGroupLeader(toMemberResponse(studyGroup.getStudyGroupLeader()))
                .studyGroupMembers(toMemberListResponse(studyGroup.getStudyGroupMembers()))
                .summary(studyGroup.getSummary())
                .season(studyGroup.getSeason())
                .likeCount(studyGroup.getLikeCount())
                .isActive(studyGroup.getIsActive())
                .name(studyGroup.getName())
                .build();

    }
    private StudyGroupMemberResponse toMemberResponse(StudyGroupMember studyGroupMember){
        return StudyGroupMemberResponse.builder()
                .id(studyGroupMember.getId())
                .name(studyGroupMember.getTeamMembers().getName())
                .major(studyGroupMember.getTeamMembers().getMajor())
                .profileUrl(studyGroupMember.getTeamMembers().getProfileUrl())
                .grade(studyGroupMember.getTeamMembers().getGrade())
                .build();
    }
    private List<StudyGroupMemberResponse> toMemberListResponse(List<StudyGroupMember> studyGroupMembers){
        return studyGroupMembers.stream()
                .map(studyGroupMember -> toMemberResponse(studyGroupMember))
                .collect(Collectors.toList());
    }


}
