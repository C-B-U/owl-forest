package com.cbu.backend.member.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDTO {
    @JsonView(MemberView.Normal.class)
    private Long id;
    @JsonView(MemberView.Normal.class)
    private String name;
    @JsonView(MemberView.AdminExtra.class)
    private String accountId;
    @JsonView(MemberView.NormalExtra.class)
    private String email;
    @JsonView(MemberView.Normal.class)
    private Integer grade;
    @JsonView(MemberView.NormalExtra.class)
    private String major;
    @JsonView(MemberView.AdminExtra.class)
    private Integer studentId;
    @JsonView(MemberView.Normal.class)
    private Integer generation;
    @JsonView(MemberView.NormalExtra.class)
    private String blogUrl;
    @JsonView(MemberView.NormalExtra.class)
    private String githubId;
    @JsonView(MemberView.Normal.class)
    private String profileUrl;
    @JsonView(MemberView.AdminExtra.class)
    private String phoneNumber;
    @JsonView(MemberView.NormalExtra.class)
    private String introduction;
    @JsonView(MemberView.Normal.class)
    private List<String> interestTags;
}
