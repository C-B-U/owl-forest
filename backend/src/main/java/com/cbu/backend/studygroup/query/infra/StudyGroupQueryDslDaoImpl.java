package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.list;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupInfo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.dto.StudyMemberInfo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class StudyGroupQueryDslDaoImpl implements StudyGroupQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;
    private final StudyGroupOrderConverter studyGroupOrderConverter;
    private final StudyGroupQDtoFactory qDtoFactory;

    @Override
    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        return jpaQueryFactory
                .from(studyGroup, authAccount)
                .leftJoin(authAccount)
                .on(studyGroup.studyGroupMember.leaderId.eq(authAccount.id))
                .leftJoin(authAccount)
                .on(authAccount.id.in(studyGroup.studyGroupMember.participantIds))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(studyGroupOrderConverter.convert(pageable.getSort()))
                .transform(groupBy(studyGroup)
                        .list(Projections.constructor(
                                StudyGroupResponse.class,
                                qDtoFactory.qStudyGroupInfo(),
                                qDtoFactory.qStudyLeaderInfo(),
                                list(qDtoFactory.qStudyMemberInfo()))));
    }

    @Override
    public StudyGroupResponse findResponseById(StudyGroupNo id) {
        StudyGroupInfo studyResult = jpaQueryFactory
                .select(qDtoFactory.qStudyGroupInfo())
                .from(studyGroup)
                .where(studyGroup.id.eq(id))
                .fetchFirst();

        StudyMemberInfo leader = jpaQueryFactory
                .select(qDtoFactory.qStudyLeaderInfo())
                .from(studyGroup, authAccount)
                .leftJoin(authAccount)
                .on(authAccount.id.eq(studyGroup.studyGroupMember.leaderId))
                .where(studyGroup.id.eq(id))
                .fetchFirst();

        StudyMemberInfo leader1 = jpaQueryFactory
                .select(qDtoFactory.qStudyLeaderInfo())
                .from(studyGroup, authAccount)
                .where(studyGroup.id.eq(id).and(authAccount.id.eq(studyGroup.studyGroupMember.leaderId)))
                .fetchFirst();

        List<StudyMemberInfo> memberResult = jpaQueryFactory
                .select(qDtoFactory.qStudyMemberInfo())
                .from(studyGroup, authAccount)
                .where(studyGroup.id.eq(id).and(authAccount.id.in(studyGroup.studyGroupMember.participantIds)))
                .fetch();

        List<StudyMemberInfo> memberResult1 = jpaQueryFactory
                .select(qDtoFactory.qStudyMemberInfo())
                .from(studyGroup, authAccount)
                .leftJoin(authAccount)
                .on(authAccount.id.in(studyGroup.studyGroupMember.participantIds))
                .where(studyGroup.id.eq(id))
                .fetch();

        return new StudyGroupResponse(studyResult, leader, memberResult);
    }
}
