package com.cbu.backend.studycrew.query.infra;

import static com.cbu.backend.studycrew.domain.QStudyCrew.*;

import com.cbu.backend.studycrew.command.domain.SortDirection;
import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class StudyCrewQueryRepository {

    private final JPAQueryFactory queryFactory;

    public StudyCrewQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public StudyCrew getStudyCrew(StudyCrewNo id) {
        return queryFactory.selectFrom(studyCrew).where(studyCrew.id.eq(id)).fetchOne();
    }

    public List<StudyCrew> getStudyCrewSortByCreatedAt(
            SortDirection sortDirection, Pageable pageable) {
        return getAllStudyCrew(
                sortDirection.getSortClassifier().apply(studyCrew.baseTime.createdAt), pageable);
    }

    public List<StudyCrew> getStudyCrewSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return getAllStudyCrew(
                sortDirection.getSortClassifier().apply(studyCrew.likeCount.count), pageable);
    }

    private List<StudyCrew> getAllStudyCrew(OrderSpecifier orderSpecifier, Pageable pageable) {
        return queryFactory
                .selectFrom(studyCrew)
                .orderBy(orderSpecifier)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
