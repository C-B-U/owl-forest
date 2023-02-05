package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.set;

import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.QStudyMember;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.dto.StudyMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class StudyGroupQueryDslDaoImpl implements StudyGroupQueryDslDao {
    private final JPAQueryFactory jpaQueryFactory;
    private final StudyGroupOrderConverter studyGroupOrderConverter;
    private final StudyGroupQDtoFactory qDtoFactory;

    @Override
    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        return jpaQueryFactory
                .select(qDtoFactory.qStudyGroupResponse())
                .from(studyGroup)
                .leftJoin(authAccount)
                .on(authAccount.id.eq(studyGroup.studyGroupMember.leaderId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(studyGroupOrderConverter.convert(pageable.getSort()))
                .fetch();
        /* Map<StudyGroupResponse, Set<AuthAccount>> transform =
                jpaQueryFactory.select(qDtoFactory.qStudyGroupResponse())
                .from(studyGroup)
                .leftJoin(authAccount).on(authAccount.id.eq(studyGroup.studyGroupMember.leaderId))
               // .leftJoin(authAccount).
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .transform(groupBy(qDtoFactory.qStudyGroupResponse()).as(set(authAccount)));

        return transform.entrySet().stream().map(entry ->
                new StudyGroupResponse(entry.getKey(),
                        entry.getValue().stream().map(StudyMember::new).toList())).toList();*/
    }

    @Override
    public Optional<StudyGroupResponse> findResponseById(StudyGroupNo id) {
        return null;
    }

    public List<StudyMember> findStudyMemberById(StudyGroupNo id) {
        return jpaQueryFactory
                .select(new QStudyMember(authAccount.id.id, authAccount.memberInfo.nickname))
                .from(studyGroup)
                .leftJoin(studyGroup.studyGroupMember.participantIds, authAccount.id)
                .where(studyGroup.id.eq(id))
                .fetch();
    }

    public List<StudyGroupResponse> findAll2(Pageable pageable) {
        Map<StudyGroupResponse, Set<AuthAccount>> transform =
                jpaQueryFactory
                        .select(qDtoFactory.qStudyGroupResponse())
                        .from(studyGroup)
                        .leftJoin(authAccount)
                        .on(authAccount.id.eq(studyGroup.studyGroupMember.leaderId))
                        .leftJoin(studyGroup.studyGroupMember.participantIds, authAccount.id)
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .transform(groupBy(qDtoFactory.qStudyGroupResponse()).as(set(authAccount)));

        return transform.entrySet().stream()
                .map(
                        entry ->
                                new StudyGroupResponse(
                                        entry.getKey(),
                                        entry.getValue().stream().map(StudyMember::new).toList()))
                .toList();
    }
}
