package com.cbu.backend.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupReuestDTO {

    @NotBlank
    @Size
    private String name;

    @NotBlank
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
    private Integer studentId;

    @NotBlank
    private String generation;

    @NotBlank
    private String phoneNumber;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String introduction;
}