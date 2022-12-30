package com.cbu.backend.studygroup.mapper;

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
                .build();
    }
    private List<StudyGroupMemberResponse> toMemberListResponse(List<StudyGroupMember> studyGroupMembers){
        return studyGroupMembers.stream()
                .map(this::toMemberResponse)
                .collect(Collectors.toList());
    }


}
