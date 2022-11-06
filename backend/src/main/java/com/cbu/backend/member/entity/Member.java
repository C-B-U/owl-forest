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
    private String study;
    private String password;

    private String accountId;

    private String email;

    private Integer grade;

    private String major;

    private String studentId;

    private String generation; //기수

    private String blogUrl;

    private String githubId;

    private String profileUrl;

    private String phoneNumber;

    private String introduction;

    @Builder
    public Member(String name, String study, String password) {
        this.name = name;
        this.study = study;
        this.password = password;
    }

    //user객체와 권한객체의 다대다 관계를 일대다, 다대일 관계의 jointable로 정의
    @OneToMany(mappedBy = "member")
    private List<InterestTag> tags = new ArrayList<InterestTag>();
}

// 다 = 태그, 일 = 멤버