package com.cbu.backend.member.dto.request;

import com.cbu.backend.member.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupRequestDTO {

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
    private Integer grade; //이거 왜 String아님?

    @NotBlank
    private String major;

    @NotBlank
    private Integer studentId; //이거도 왜 아님?

    @NotBlank
    private String generation;

    @NotBlank
    private String phoneNumber;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String introduction;

}