package com.cbu.backend.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetail {
  private String blogUrl;

  private String githubId;

  @OneToMany(mappedBy = "member")
  private List<InterestTag> tags = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private AcademicStatus academicStatus;

  @Enumerated(EnumType.STRING)
  private Major major;

  @Enumerated(EnumType.STRING)
  private Major subMajor;

  private String email;

  @Lob private String introduction;
}


