package com.cbu.backend.member.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class MemberDetail {
  private String blogUrl;

  private String githubId;

  @OneToMany(mappedBy = "member")
  private List<InterestTag> tags = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private AcademicStatus academicStatus;

  @Enumerated(EnumType.STRING)
  private Major major;

  private String email;

  @Lob private String introduction;
}
