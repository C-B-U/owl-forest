package com.cbu.backend.studygroup.dto.request;

import com.cbu.backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudyGroupRequestDTO {
    private String name;
    private String summary;
    //private Member teamLeader;
    //private List<Member> teamMembers = new ArrayList<>();
    private Integer likeCount;
    private Integer season;
}
