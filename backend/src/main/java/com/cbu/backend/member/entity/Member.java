package com.cbu.backend.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String accountId;

    private String email;

    private Integer grade;

    private String major;

    private Integer studentId;

    private String generation;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String phoneNumber;

    private String introduction;

    //회원가입 방식?

    @Builder
    public Member(String name, String password, String accountId) {
        this.name = name;
        this.password = password;
        this.accountId = accountId;
    }

    @OneToMany(mappedBy = "member")
    private List<InterestTag> tags = new ArrayList<InterestTag>();
}
