package com.cbu.backend.studygroup.entity;

import com.cbu.backend.member.entity.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * StudyGroup 과 Member의 M대N 관계를 풀어내는 중간 엔티티
 *
 * @author ohksj(김승진)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroupMember {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member teamMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    public StudyGroupMember(Member member, StudyGroup studyGroup) {
        this.teamMember = member;
        this.studyGroup = studyGroup;
    }
}
