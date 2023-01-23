package com.cbu.backend.studycrew.query.infra;

import static com.cbu.backend.studycrew.command.domain.QStudyCrew.studyCrew;

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
public class StudyCrewDao {

    private final JPAQueryFactory queryFactory;

    public StudyCrewDao(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public StudyCrew findStudyCrew(StudyCrewNo id) {
        return queryFactory.selectFrom(studyCrew).where(studyCrew.id.eq(id)).fetchOne();
    }

    public List<StudyCrew> findStudyCrewSortByCreatedAt(
            SortDirection sortDirection, Pageable pageable) {
        return findAllStudyCrew(
                sortDirection.getSortClassifier().apply(studyCrew.baseTime.createdAt), pageable);
    }

    public List<StudyCrew> getStudyCrewSortByLikeCount(
            SortDirection sortDirection, Pageable pageable) {
        return findAllStudyCrew(
                sortDirection.getSortClassifier().apply(studyCrew.likeCount.count), pageable);
    }

    private List<StudyCrew> findAllStudyCrew(OrderSpecifier orderSpecifier, Pageable pageable) {
        return queryFactory
                .selectFrom(studyCrew)
                .orderBy(orderSpecifier)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
