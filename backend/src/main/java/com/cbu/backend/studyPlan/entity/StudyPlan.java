package com.cbu.backend.studyPlan.entity;

import com.cbu.backend.global.BaseTime;
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

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String generationNum;
    @Column(nullable = false)
    private String rule;
    @Column(nullable = false)
    private String teamMember;
    @Column(nullable = false)
    private String book;
    @Column(nullable = false)
    private String studyGroupId;

    @Embedded
    private BaseTime baseTime;

//    @OneToOne
//    @JoinColumn(name = "studyGroupId")
//    private

    @Builder
    public StudyPlan(String title, String  generationNum, String rule, String teamMember, String book, String studyGroupId) {
        this.title = title;
        this.generationNum = generationNum;
        this.rule = rule;
        this.teamMember = teamMember;
        this.book = book;
        this.studyGroupId = studyGroupId;
    }
}

