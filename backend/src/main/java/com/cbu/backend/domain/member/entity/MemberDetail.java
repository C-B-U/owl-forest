package com.cbu.backend.domain.member.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
