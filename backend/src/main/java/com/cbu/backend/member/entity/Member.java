package com.cbu.backend.member.entity;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String password;

    private String accountId;

    private String email;

    private Integer grade;

    private String major;

    private Integer studentId;

    private Integer generation;

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
