package com.cbu.backend.studyPlan.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "study_plan")
public class StudyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 // 예약어 문제?? 일단 Column 삽입
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "generation_num", nullable = false)
    private String generationNum;
    @Column(name = "rule", nullable = false)
    private String rule;
    @Column(name = "team_member", nullable = false)
    private String teamMember;
    @Column(name = "book", nullable = false)
    private String book;

    @Builder
    public StudyPlan(String title, String  generationNum, String rule, String teamMember, String book) {
        this.title = title;
        this.generationNum = generationNum;
        this.rule = rule;
        this.teamMember = teamMember;
        this.book = book;
    }
}
