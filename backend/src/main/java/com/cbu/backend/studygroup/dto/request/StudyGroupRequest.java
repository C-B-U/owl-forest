package com.cbu.backend.studygroup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupRequest {
    private String name;
    private String summary;
    //private Member teamLeader;
    //private List<Member> teamMembers = new ArrayList<>();
    private Integer likeCount;
    private Integer season;
}
