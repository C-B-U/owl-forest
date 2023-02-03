package com.cbu.backend.studygroup.query.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
public class StudyGroupResponse {
    private StudyGroupInfo studyGroupInfo;
    private StudyMemberInfo studyLeader;
    private List<StudyMemberInfo> participants;

    public StudyGroupResponse(StudyGroupInfo studyGroupInfo, StudyMemberInfo studyLeader, List<StudyMemberInfo> participants) {
        this.studyGroupInfo = studyGroupInfo;
        this.studyLeader = studyLeader;
        this.participants = participants;
    }
}
