package com.cbu.backend.studygroup;

import com.cbu.backend.global.audit.AuditListener;
import com.cbu.backend.global.audit.Auditable;
import com.cbu.backend.global.audit.BaseTime;
import com.cbu.backend.global.audit.SoftDeleteSupport;
import com.cbu.backend.member.domain.Member;

import lombok.*;

import org.hibernate.annotations.Formula;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

@Getter
@Entity
@SoftDeleteSupport
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroup implements Auditable {

    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String name;

    @Lob private String description;

    @Enumerated(EnumType.STRING)
    private StudyGroupStatus studyGroupStatus;

    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.ALL)
    private Set<LikeMember> likeMember = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Member leader;

    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.ALL)
    private Set<StudyMember> studyMembers = new HashSet<>();

    @Formula("(SELECT count(*) FROM study_activity sa WHERE sa.study_group_id = id)")
    private Integer numOfStudyActivity;

    @Formula("(SELECT count(*) FROM like_member lm WHERE lm.study_group_id = id)")
    private Integer numOfLike;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public StudyGroup(String name, String description, Member leader, Set<Member> studyMembers) {
        this.name = name;
        this.description = description;
        this.studyGroupStatus = StudyGroupStatus.ACTIVE;
        this.leader = leader;
        organizeStudyMembers(studyMembers);
    }

    public void finishStudy() {
        this.studyGroupStatus = StudyGroupStatus.FINISHED;
    }

    public void deleteStudy() {
        this.baseTime.delete();
    }

    public void updateStudyGroup(
            String name, String description, Member leader, Set<Member> studyMembers) {
        this.name = name;
        this.description = description;
        this.leader = leader;
        organizeStudyMembers(studyMembers);
    }

    public void organizeStudyMembers(Set<Member> studyMembers) {
        this.studyMembers =
                studyMembers.stream()
                        .map(member -> new StudyMember(this, member))
                        .collect(Collectors.toSet());
    }
}
