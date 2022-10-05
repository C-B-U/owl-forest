package com.cbu.backend.studyGroup.entity;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.studyJournal.entity.StudyJournal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "studyGroup")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String summary;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Member teamLeader;

    @OneToMany(mappedBy = "member")
    private List<Member> teamMembers = new ArrayList<>();

    @OneToMany(mappedBy = "studyJournal")
    private List<StudyJournal> journals = new ArrayList<>();

    private Integer like = 0;

    @Builder
    public StudyGroup(Long id, String name, String summary, Member teamLeader, List<Member> teamMembers, List<StudyJournal> journals, Integer like) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.teamLeader = teamLeader;
        this.teamMembers = teamMembers;
        this.journals = journals;
        this.like = like;
    }

    public StudyGroup update(StudyGroup studyGroup) {
        this.name = studyGroup.getName();
        this.summary = studyGroup.getSummary();
        this.teamLeader = studyGroup.getTeamLeader();
        this.teamMembers = studyGroup.getTeamMembers();
        this.journals = studyGroup.getJournals();
        this.like = studyGroup.getLike();

        return this;
    }

    public boolean isMemberDuplicated(StudyGroup studyGroup) {
        return studyGroup.getTeamMembers().stream()
//                .mapToLong(i -> i.getId())
                .distinct().mapToInt(i -> 1).sum() == studyGroup.getTeamMembers().size();
    }

    public void updateLike(Integer like) { // like는 -1(좋아요 취소) or +1(좋아요)
        if(this.like + like >= 0){
            this.like += like;
        }
    }

}