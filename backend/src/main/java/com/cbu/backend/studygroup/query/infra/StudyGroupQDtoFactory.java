package com.cbu.backend.studygroup.query.infra;

import com.cbu.backend.studygroup.query.dto.QStudyGroupResponse;
import com.cbu.backend.studygroup.query.dto.QStudyMember;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

@Component
public class StudyGroupQDtoFactory {
    private final QStudyMember qStudyMember = new QStudyMember(authAccount.id.id, authAccount.memberInfo.nickname);
    @Bean
    public QStudyGroupResponse qStudyGroupResponse() {
        return new QStudyGroupResponse(studyGroup.id.id, studyGroup.name, studyGroup.description, studyGroup.likeCount.memberIds.size(), studyGroup.studyGroupStatus, qStudyMember);
    }
}
