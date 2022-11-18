package com.cbu.backend.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignupRequest {

    @NotBlank
    @Size
    private String name;

    @NotBlank
    @Setter
    private String password;

    @NotBlank
    private String accountId;

    @NotBlank
    private String email;

    @NotBlank
    private Integer grade;

    @NotBlank
    private String major;

    @NotBlank
    private String studentId;

    @NotBlank
    private Integer generation;

    @NotBlank
    private String phoneNumber;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String introduction;

}