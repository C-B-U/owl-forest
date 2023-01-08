package com.cbu.backend.member.dto.request;

import com.cbu.backend.member.entity.AcademicStatus;
import com.cbu.backend.member.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequest {
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
}
