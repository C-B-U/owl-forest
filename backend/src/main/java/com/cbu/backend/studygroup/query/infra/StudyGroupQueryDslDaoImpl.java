package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

import com.cbu.backend.studygroup.command.domain.StudyGroup;
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

    public List<StudyGroup> findAllStudyGroup(Pageable pageable) {
        return queryFactory
                .selectFrom(studyGroup)
                .orderBy(studyGroupOrderConverter.convert(pageable.getSort()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
