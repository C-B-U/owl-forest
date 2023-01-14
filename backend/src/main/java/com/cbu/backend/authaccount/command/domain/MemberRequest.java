package com.cbu.backend.authaccount.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    @NotBlank private String name;
    @NotBlank private String nickname;
    @URL private String blogUrl;
    private String githubId;
    @NotBlank private AcademicStatus academicStatus;
    @NotBlank private Major major;
    private Major subMajor;
    @Email private String email;
    private String introduction;
    @NotBlank private String studentId;
    @NotBlank private String phoneNumber;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .memberPublicInfo(toPublicInfo())
                .memberPrivacy(toPrivacy())
                .build();
    }

    private MemberPrivacy toPrivacy() {
        return MemberPrivacy.builder()
                .studentId(studentId)
                .phoneNumber(phoneNumber)
                .build();
    }

    private MemberPublicInfo toPublicInfo() {
        return MemberPublicInfo.builder()
                .blogUrl(blogUrl)
                .githubId(githubId)
                .academicStatus(academicStatus)
                .major(major)
                .subMajor(subMajor)
                .email(email)
                .introduction(introduction)
                .build();
    }
}
