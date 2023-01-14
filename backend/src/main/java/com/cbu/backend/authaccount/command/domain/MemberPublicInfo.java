package com.cbu.backend.authaccount.command.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Getter
@Setter
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

    @Lob private String introduction;
}
