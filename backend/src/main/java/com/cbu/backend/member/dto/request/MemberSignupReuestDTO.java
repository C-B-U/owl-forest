package com.cbu.backend.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupReuestDTO {

    private String name;

    private String study;

    private String password;

    private String accountId;

    @Email
    private String email;

    private int grade;

    private String major;

    private String studentId;

    private String generation;

    
    private String phoneNumber;

    @URL
    private String blogUrl;

    private String githubId;

    @URL
    private String profileUrl;

    private String introduction;
}