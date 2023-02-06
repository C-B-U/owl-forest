package com.cbu.backend.studygroup;

import com.cbu.backend.authaccount.command.domain.Member;
import com.cbu.backend.global.BaseTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroup {

    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String name;

    @Lob private String description;

    @Enumerated(EnumType.STRING)
    private StudyGroupStatus studyGroupStatus;

    @OneToMany(mappedBy = "studyGroup")
    private Set<LikeCount> likeCount = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Member leader;

    @OneToMany(mappedBy = "studyGroup")
    private Set<StudyMember> studyMembers = new HashSet<>();

    @Embedded private BaseTime baseTime;

    @Builder
    public StudyGroup(
            String name, String description, Member leader, Set<StudyMember> studyMembers) {
        this.name = name;
        this.description = description;
        this.studyGroupStatus = StudyGroupStatus.ACTIVE;
        this.leader = leader;
        this.studyMembers = studyMembers;
        this.baseTime = new BaseTime();
    }

    public void finishStudy() {
        this.studyGroupStatus = StudyGroupStatus.FINISHED;
    }

    public void deleteStudy() {
        this.baseTime.delete();
    }

    public void updateStudyGroup(
            String name, String description) { // TODO Member, Leader 추가
        this.name = name;
        this.description = description;
    }

    public void cancelLike(LikeCount likeCount) {
        if (this.likeCount.isEmpty()) {
            throw new LikeCountMinusException();
        }
        this.likeCount.remove(likeCount);
    }

    public void organizeStudyMembers(Member leader, List<StudyMember> studyMembers) {
        this.leader = leader;
        clearStudyMembers();
        this.studyMembers.addAll(studyMembers);
    }

    private void clearStudyMembers() {
        this.studyMembers.clear();
    }
}
