package com.cbu.backend.support.fixture.member;

import com.cbu.backend.member.domain.AcademicStatus;
import com.cbu.backend.member.domain.Major;
import com.cbu.backend.member.domain.OAuth2Info;
import com.cbu.backend.member.domain.Role;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public enum MemberFixture {
    ;
    private String name;
    private String blogUrl;
    private String githubId;

    private AcademicStatus academicStatus;

    private Major major;

    private Major subMajor;
    private String email;
    private Integer grade;
    private String studentId;
    private String phoneNumber;
    @Lob
    private String introduction;

    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    @Embedded private OAuth2Info oAuth2Info;

}
