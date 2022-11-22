package com.cbu.backend.studyplan.entity;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.studygroup.entity.StudyGroup;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
//    private String title;
//    @Column(nullable = false)
//    private String generationNum;
    @Column(nullable = false)
    private String rule;

    @Column(nullable = false)
    private String book;

    @Embedded
    private BaseTime baseTime;

    @OneToOne
    @JoinColumn(name = "studyGroupId") // 스터디 그룹 아이디
    private StudyGroup studyGroup;

    @Builder
    public StudyPlan(String rule, String book, String studyGroupId) {
        this.rule = rule;
        this.book = book;
    }
}

