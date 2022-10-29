package com.cbu.backend.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String accountId;
    private String email;
    private String password;
    private String name;
    private String department; //학과
    private Integer generation; //기수
    private Integer grade; //학년

    private Integer student_number; //학번
    private String phone_number; //전화번호

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.NONE;

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_MEMBER;

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();


    @Builder
    public Member(String accountId, String email, String password, String name, String department, Integer generation, Integer grade, Integer student_number, String phone_number, AuthProvider authProvider) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.department = department;
        this.generation = generation;
        this.grade = grade;
        this.student_number = student_number;
        this.phone_number = phone_number;
        this.authProvider = authProvider;
    }
    public void update() {
        baseTimeEntity.update();
    }

    public void delete() {
        baseTimeEntity.delete();
    }
}
