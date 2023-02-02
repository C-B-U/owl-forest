package com.cbu.backend.authaccount.command.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MemberPublicInfo {
    private String blogUrl;

    private String githubId;

    @Enumerated(EnumType.STRING)
    private AcademicStatus academicStatus;

    @Enumerated(EnumType.STRING)
    private Major major;

    @Enumerated(EnumType.STRING)
    private Major subMajor;

    private String email;

    private Integer grade;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "member_interest", joinColumns = @JoinColumn(name = "member_id"))
    private List<MemberInterest> interests;

    @Lob private String introduction;
}
