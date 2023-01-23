package com.cbu.backend.studygroup.query.infra;

import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

import com.cbu.backend.studygroup.command.domain.SortDirection;
import com.cbu.backend.studygroup.command.domain.StudyGroup;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class StudyGroupDao {

    private final JPAQueryFactory queryFactory;

    public StudyGroupDao(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public StudyGroup findStudyGroup(StudyGroupNo id) {
        return queryFactory.selectFrom(studyGroup).where(studyGroup.id.eq(id)).fetchOne();
    }

    public List<StudyGroup> findStudyGroupSortByCreatedAt(
            SortDirection sortDirection, Pageable pageable) {
        return findAllStudyGroup(
                sortDirection.getSortClassifier().apply(studyGroup.baseTime.createdAt), pageable);
    }

    public List<StudyGroup> findStudyGroupSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return findAllStudyGroup(
                sortDirection.getSortClassifier().apply(studyGroup.likeCount.memberIds.size()), pageable);
    }

    private List<StudyGroup> findAllStudyGroup(OrderSpecifier orderSpecifier, Pageable pageable) {
        return queryFactory
                .selectFrom(studyGroup)
                .orderBy(orderSpecifier)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
