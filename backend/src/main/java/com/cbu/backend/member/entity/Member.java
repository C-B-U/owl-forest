package com.cbu.backend.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
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

    private String studentId;

    private Integer generation;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String phoneNumber;

    private String introduction;

    @OneToMany(mappedBy = "member")
    private List<InterestTag> tags = new ArrayList<InterestTag>();

    @Setter
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String password, String accountId, String email, int grade, String major,
                  String studentId, int generation, String blogUrl, String githubId, String profileUrl,
                  String phoneNumber, String introduction) {

        this.name = name;
        this.password = password;
        this.accountId = accountId;
        this.email = email;
        this.grade = grade;
        this.major = major;
        this.studentId = studentId;
        this.generation = generation;
        this.blogUrl = blogUrl;
        this.githubId = githubId;
        this.profileUrl = profileUrl;
        this.phoneNumber = phoneNumber;
        this.introduction = introduction;
    }

}




