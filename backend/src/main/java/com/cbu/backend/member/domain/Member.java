package com.cbu.backend.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;
    private String blogUrl;
    private String githubId;

    @Enumerated(EnumType.STRING)
    private AcademicStatus academicStatus;

    @Enumerated(EnumType.STRING)
    private Major major;

    private String email;
    private Integer grade;
    private String studentId;
    private String phoneNumber;
    private String profileUrl;
    @Lob private String introduction;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    @Embedded private OAuth2Info oAuth2Info;

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
    }

    @Builder
    public Member(OAuth2Info oAuth2Info, String name, String email) {
        this.oAuth2Info = oAuth2Info;
        this.name = name;
        this.email = email;
    }

    public void update(
            String name,
            String blogUrl,
            String githubId,
            AcademicStatus academicStatus,
            Major major,
            String email,
            Integer grade,
            String studentId,
            String phoneNumber,
            String profileUrl,
            String introduction) {
        this.name = name;
        this.blogUrl = blogUrl;
        this.githubId = githubId;
        this.academicStatus = academicStatus;
        this.major = major;
        this.email = email;
        this.grade = grade;
        this.studentId = studentId;
        this.profileUrl = profileUrl;
        this.phoneNumber = phoneNumber;
        this.introduction = introduction;
    }
}
