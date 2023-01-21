package com.cbu.backend.studycrew.query.infra;

import static com.cbu.backend.studycrew.domain.QStudyCrew.*;

import com.cbu.backend.studycrew.command.domain.SortDirection;
import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
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
                getOrderSpecifier(studyCrew.baseTime.createdAt, sortDirection), pageable);
    }

    public List<StudyCrew> getStudyCrewSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return getAllStudyCrew(
                getOrderSpecifier(studyCrew.likeCount.count, sortDirection), pageable);
    }

    private OrderSpecifier getOrderSpecifier(
            ComparableExpressionBase field, SortDirection sortDirection) {
        return sortDirection == SortDirection.ASC ? field.asc() : field.desc();
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
