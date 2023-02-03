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
        return new QStudyMemberInfo(authAccount.id.id, authAccount.memberInfo.name);
    }

    @Bean
    public QStudyMemberInfo qStudyLeaderInfo() {
        return new QStudyMemberInfo(
                studyGroup.studyGroupMember.leaderId.id, authAccount.memberInfo.name);
    }

    @Bean
    public QStudyGroupInfo qStudyGroupInfo() {
        return new QStudyGroupInfo(
                studyGroup.id.id,
                studyGroup.name,
                studyGroup.description,
                studyGroup.likeCount.memberIds.size(),
                studyGroup.studyGroupStatus.stringValue());
    }
}
