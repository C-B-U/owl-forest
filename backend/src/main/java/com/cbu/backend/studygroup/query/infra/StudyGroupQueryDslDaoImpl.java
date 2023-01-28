package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyGroupQueryDslDaoImpl implements StudyGroupQueryDslDao {

    private final JPAQueryFactory queryFactory;
    private final StudyGroupOrderConverter studyGroupOrderConverter;
    private final StudyGroupQDtoFactory qDtoFactory;

    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        return queryFactory
                .select(qDtoFactory.qStudyGroupResponse())
                .from(studyGroup)
                .orderBy(studyGroupOrderConverter.convert(pageable.getSort()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public StudyGroupResponse findResponseById(StudyGroupNo id) {
        return queryFactory
                .select(qDtoFactory.qStudyGroupResponse())
                .from(studyGroup)
                .where(studyGroup.id.eq(id))
                .fetchFirst();
    }
}
