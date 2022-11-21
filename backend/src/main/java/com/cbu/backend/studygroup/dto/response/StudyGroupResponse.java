package com.cbu.backend.studygroup.dto.response;

import com.cbu.backend.member.dto.response.MemberView;
import com.cbu.backend.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupResponse {
    private String name;
    private String summary;
    //private Member teamLeader;
    //private List<Member> teamMembers = new ArrayList<>();
    private Integer likeCount;
    private Integer season;
    //private LocalDateTime startTime;
}

/*
public class StudyGroupResponse {
    @JsonView(MemberView.Normal.class)
    private String name;
    @JsonView(MemberView.Normal.class)
    private String summary;
    //@JsonView(MemberView.AdminExtra.class)
    //private Member teamLeader;
    //@JsonView(MemberView.Normal.class)
    //private List<Member> teamMembers = new ArrayList<>();
    @JsonView(MemberView.Normal.class)
    private Integer likeCount;
    @JsonView(MemberView.NormalExtra.class)
    private Integer season;
    //@JsonView(MemberView.Normal.class)
    //private LocalDateTime startTime;
}*/
