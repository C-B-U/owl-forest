package com.cbu.backend.studygroup;

import com.cbu.backend.global.audit.AuditListener;
import com.cbu.backend.global.audit.Auditable;
import com.cbu.backend.global.audit.BaseTime;
import com.cbu.backend.global.audit.SoftDeleteSupport;
import com.cbu.backend.member.domain.Member;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@SoftDeleteSupport
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeMember implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public LikeMember(Member member, StudyGroup studyGroup) {
        this.member = member;
        this.studyGroup = studyGroup;
        addLike();
    }

    public void addLike() {
        studyGroup.getLikeMember().add(this);
    }

    public void cancelLike() {
        if (studyGroup.getLikeMember().isEmpty()) {
            throw new LikeCountMinusException();
        }
        studyGroup.getLikeMember().remove(this);
    }
}
