package com.cbu.backend.member.dto;

import com.cbu.backend.member.domain.AcademicStatus;
import com.cbu.backend.member.domain.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberRequest {
    @NotBlank
    private String name;
    private String blogUrl;
    private String githubId;
    @NotBlank
    private AcademicStatus academicStatus;
    @NotBlank
    private Major major;
    private Major subMajor;
    @Email
    @NotBlank
    private String email;
    private Integer grade;
    @NotBlank
    //format 설정 TODO
    private String studentId;
    @NotBlank
    //format 설정 TODO
    private String phoneNumber;
    private String introduction;
}
