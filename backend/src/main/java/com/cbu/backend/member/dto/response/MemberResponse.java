package com.cbu.backend.member.dto.response;

import com.cbu.backend.member.entity.InterestTag;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponse {
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
  private String studentId;

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
  private List<InterestTag> interestTags;
}
