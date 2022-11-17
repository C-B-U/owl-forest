package com.cbu.backend.member.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.cbu.backend.member.entity.Member;
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
    private Integer generation;
}