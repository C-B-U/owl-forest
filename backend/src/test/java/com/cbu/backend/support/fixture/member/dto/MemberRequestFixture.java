package com.cbu.backend.support.fixture.member.dto;

import com.cbu.backend.authaccount.command.domain.AcademicStatus;
import com.cbu.backend.authaccount.command.domain.Major;
import com.cbu.backend.authaccount.command.domain.MemberRequest;

public enum MemberRequestFixture {
    SAMPLE1(
            "박현준",
            "PADO",
            "www.example.com",
            "phjppo0918",
            AcademicStatus.ATTEND,
            Major.BUSINESS_ADMINISTRATION,
            Major.COMPUTER,
            "phjppo0918@gmail.com",
            "hihihihihihi",
            "2018314014",
            "010-1111-2222"),
    SAMPLE2(
            "박현준2",
            "PADO2",
            "www.example.com",
            "ph]0918",
            AcademicStatus.ATTEND,
            Major.BUSINESS_ADMINISTRATION,
            Major.COMPUTER,
            "phjppo0918@gmail.com",
            "hihihihihihi",
            "2018314994",
            "010-1111-2222"),
    SAMPLE3(
            "박현준3",
            "PADO3",
            "www.example.com",
            "phjphkj918",
            AcademicStatus.ATTEND,
            Major.BUSINESS_ADMINISTRATION,
            Major.COMPUTER,
            "phjppo0918@gmail.com",
            "hihihihihihi",
            "201840914",
            "010-1111-2222");
    private final String name;
    private final String nickname;
    private final String blogUrl;
    private final String githubId;
    private final AcademicStatus academicStatus;
    private final Major major;
    private final Major subMajor;
    private final String email;
    private final String introduction;
    private final String studentId;
    private final String phoneNumber;

    MemberRequestFixture(
            String name,
            String nickname,
            String blogUrl,
            String githubId,
            AcademicStatus academicStatus,
            Major major,
            Major subMajor,
            String email,
            String introduction,
            String studentId,
            String phoneNumber) {
        this.name = name;
        this.nickname = nickname;
        this.blogUrl = blogUrl;
        this.githubId = githubId;
        this.academicStatus = academicStatus;
        this.major = major;
        this.subMajor = subMajor;
        this.email = email;
        this.introduction = introduction;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
    }

    public MemberRequest toMemberRequest() {
        return new MemberRequest(
                name,
                nickname,
                blogUrl,
                githubId,
                academicStatus,
                major,
                subMajor,
                email,
                introduction,
                studentId,
                phoneNumber);
    }
}
