package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

import com.cbu.backend.studygroup.query.dto.QStudyGroupInfo;
import com.cbu.backend.studygroup.query.dto.QStudyMemberInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudyGroupQDtoFactory {

    @Bean
    public QStudyMemberInfo qStudyMemberInfo() {
        return new QStudyMemberInfo(authAccount.id, authAccount.memberInfo.name);
    }

    @Bean
    public QStudyGroupInfo qStudyGroupInfo() {
        return new QStudyGroupInfo(
                studyGroup.id,
                studyGroup.name,
                studyGroup.description,
                studyGroup.likeCount.memberIds.size(),
                studyGroup.studyGroupStatus.stringValue(),
                new QStudyMemberInfo(authAccount.id, authAccount.memberInfo.name));
    }
}
