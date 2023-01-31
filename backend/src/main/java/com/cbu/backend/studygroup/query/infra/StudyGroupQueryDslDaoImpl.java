package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.authaccount.command.domain.QAuthAccount.authAccount;
import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;
import static com.querydsl.core.types.dsl.Expressions.list;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupInfo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StudyGroupQueryDslDaoImpl implements StudyGroupQueryDslDao {

    private final JPAQueryFactory jpaQueryFactory;
    private final StudyGroupOrderConverter studyGroupOrderConverter;
    private final StudyGroupQDtoFactory qDtoFactory;

    // 리스트 조회
    @Override
    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        List<Tuple> query = getQuery()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(studyGroupOrderConverter.convert(pageable.getSort()))
                .fetch();

        return query.stream()
                .map(this::getStudyGroupResponse)
                .collect(Collectors.toList());
    }

    // 단일 조회
    @Override
    public StudyGroupResponse findResponseById(StudyGroupNo id) {
        Tuple query = getQuery()
                .where(studyGroup.id.eq(id))
                .fetchFirst();

        return getStudyGroupResponse(query);
    }

    // StudyGroupResponse로 변환하는 부분만 뽑아냄
    private StudyGroupResponse getStudyGroupResponse(Tuple query) {
        if (query == null) {
            return null;
        }
        return new StudyGroupResponse(query.get(0, StudyGroupInfo.class), query.get(1, List.class));
    }

    // 조회 쿼리의 공통부분 뽑아냄
    private JPAQuery<Tuple> getQuery() {
        return jpaQueryFactory
                .select(qDtoFactory.qStudyGroupInfo(), list(qDtoFactory.qStudyMemberInfo()))
                .from(studyGroup, authAccount)
                .leftJoin(studyGroup)
                .on(studyGroup.studyGroupMember.leaderId.eq(authAccount.id))
                .leftJoin(authAccount)
                .on(authAccount.id.eqAny(studyGroup.studyGroupMember.participantIds));
    }
}
