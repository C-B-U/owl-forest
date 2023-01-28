package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

import com.cbu.backend.studygroup.query.dto.QStudyGroupResponse;
import com.cbu.backend.studygroup.query.dto.QStudyMember;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudyGroupQDtoFactory {
    private final QStudyMember qStudyMember =
            new QStudyMember(authAccount.id, authAccount.memberInfo.name);

    @Bean
    public QStudyGroupResponse qStudyGroupResponse() {
        return new QStudyGroupResponse(
                studyGroup.id,
                studyGroup.name,
                studyGroup.description,
                studyGroup.likeCount.memberIds.size(),
                studyGroup.studyGroupStatus.stringValue(),
                qStudyMember);
    }
}
