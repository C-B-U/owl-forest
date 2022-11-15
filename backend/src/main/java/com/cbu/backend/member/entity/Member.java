package com.cbu.backend.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    private Integer studentId;

    private String generation;

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String phoneNumber;

    private String introduction;

    @Builder
    public Member(String name, String study, String password) {
        this.name = name;
        this.password = password;
    }
    @OneToMany(mappedBy = "member")
    private List<InterestTag> tags = new ArrayList<InterestTag>();
}
