package com.cbu.backend.studygroup.dto.response;

import com.cbu.backend.studygroup.entity.StudyGroupMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupResponse {
    private String name;
    private String summary;
    private StudyGroupMemberResponse studyGroupLeader;
    private List<StudyGroupMemberResponse> studyGroupMembers = new ArrayList<>();
    private Boolean isActive;
    private Integer likeCount;
    private Integer season;
    //ToDo StudyActivityLog 처리 필요
}