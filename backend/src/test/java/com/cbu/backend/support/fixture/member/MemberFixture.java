package com.cbu.backend.support.fixture.member;

import com.cbu.backend.member.domain.*;

import lombok.Getter;

@Getter
public enum MemberFixture {
    HERRY(
            "해리",
            "http://www.herry.com",
            "phjppo0918",
            AcademicStatus.ABSENCE,
            Major.AI,
            null,
            "aaa@bb.com",
            4,
            "2018314014",
            "010-2222-3333",
            "안녕하세용",
            new OAuth2Info(AuthProvider.KAKAO, "aaa"));
    private final String name;
    private final String blogUrl;
    private final String githubId;
    private final AcademicStatus academicStatus;
    private final Major major;
    private final Major subMajor;
    private final String email;
    private final Integer grade;
    private final String studentId;
    private final String phoneNumber;
    private final String introduction;
    private final OAuth2Info oAuth2Info;

    MemberFixture(
            String name,
            String blogUrl,
            String githubId,
            AcademicStatus academicStatus,
            Major major,
            Major subMajor,
            String email,
            Integer grade,
            String studentId,
            String phoneNumber,
            String introduction,
            OAuth2Info oAuth2Info) {
        this.name = name;
        this.blogUrl = blogUrl;
        this.githubId = githubId;
        this.academicStatus = academicStatus;
        this.major = major;
        this.subMajor = subMajor;
        this.email = email;
        this.grade = grade;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.introduction = introduction;
        this.oAuth2Info = oAuth2Info;
    }

    public Member toEntity() {
        return Member.builder().email(email).name(name).oAuth2Info(oAuth2Info).build();
    }
}
