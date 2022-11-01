package com.cbu.backend.member.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String study;
    private String password;

    @Builder
    public Member(String name, String study, String password) {
        this.name = name;
        this.study = study;
        this.password = password;
    }
}
