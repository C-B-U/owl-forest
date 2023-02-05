package com.cbu.backend.studygroup.query.infra;
/*
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.studygroup.StudyGroup;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.member.entity.AuthAccountFixture;
import com.cbu.backend.support.fixture.studygroup.entity.StudyGroupFixture;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import javax.persistence.EntityManager;

@Slf4j
@DisplayName("StudyGroupQueryDslDaoImpl 클래스의")
@EnableDataBaseTest
class StudyGroupQueryDslDaoImplTest {

    @Autowired EntityManager em;
    @Autowired JPAQueryFactory jpaQueryFactory;
    @Autowired StudyGroupQueryDslDaoImpl studyGroupQueryDslDao;

    //    @Nested
    //    @DisplayName("단일 상세 조회가")
    //    class FindDetail {
    //        @Test
    //        @DisplayName("수행되는가")
    //        void successRun() throws Exception {
    //            // given
    //            AuthAccount account1 = AuthAccountFixture.SAMPLE1.toEntity();
    //            AuthAccount account2 = AuthAccountFixture.SAMPLE2.toEntity();
    //            AuthAccount account3 = AuthAccountFixture.SAMPLE3.toEntity();
    //            StudyGroup studyGroup =
    //                    StudyGroupFixture.SAMPLE1.toEntity(
    //                            account2.getId(), List.of(account1.getId(), account3.getId()));
    //
    //            em.persist(account1);
    //            em.persist(account2);
    //            em.persist(account3);
    //            em.persist(studyGroup);
    //
    //            // when
    //            StudyGroupResponse result =
    // studyGroupQueryDslDao.findResponseById(studyGroup.getId());
    //
    //            log.info("================TEST=================");
    //            log.info(result.toString());
    //            log.info("=====================================");
    //
    //            // then
    //            StudyGroupInfo studyGroupInfo = result.getStudyGroupInfo();
    //            StudyMemberInfo studyLeaderInfo = result.getStudyLeader();
    //            List<StudyMemberInfo> studyParticipants = result.getParticipants();
    //
    //            assertThat(studyGroupInfo.getId()).isEqualTo(studyGroup.getId().getId());
    //            assertThat(studyGroupInfo.getStudyGroupStatus())
    //                    .isEqualTo(studyGroup.getStudyGroupStatus().toString());
    //            assertThat(studyGroupInfo.getName()).isEqualTo(studyGroup.getName());
    //            assertThat(studyGroupInfo.getLikeCount())
    //                    .isEqualTo(studyGroup.getLikeCount().getMemberIds().size());
    //            assertThat(studyLeaderInfo.getId().toString())
    //
    // .isEqualTo(studyGroup.getStudyGroupMember().getLeaderId().getId().toString());
    //            assertThat(studyParticipants.size())
    //                    .isEqualTo(studyGroup.getStudyGroupMember().getParticipantIds().size());
    //        }
    //    }

    @Nested
    @DisplayName("전체 조회")
    class FindList {
        @Test
        @DisplayName("최신순이 수행되는가")
        void successByCreatedAt() throws Exception {
            // given
            AuthAccount account1 = AuthAccountFixture.SAMPLE1.toEntity();
            AuthAccount account2 = AuthAccountFixture.SAMPLE2.toEntity();
            AuthAccount account3 = AuthAccountFixture.SAMPLE3.toEntity();

            StudyGroup studyGroup1 =
                    StudyGroupFixture.SAMPLE1.toEntity(account1.getId(), List.of(account2.getId()));
            StudyGroup studyGroup2 =
                    StudyGroupFixture.SAMPLE2.toEntity(
                            account2.getId(), List.of(account3.getId(), account1.getId()));

            em.persist(account1);
            em.persist(account2);
            em.persist(account3);

            em.persist(studyGroup1);
            em.persist(studyGroup2);

            // when
            List<StudyGroupResponse> result =
                    studyGroupQueryDslDao.findAllStudyGroup(getPageable());

            result.forEach(
                    r ->
                            log.info(
                                    "{}, {}, {}, {}, {}, {}",
                                    r.getId(),
                                    r.getName(),
                                    r.getStudyGroupStatus(),
                                    r.getLikeCount(),
                                    r.getDescription(),
                                    r.getStudyLeader().getId()));

            // then
            assertThat(result.size()).isEqualTo(2);
            assertThat(result.get(0).getId()).isEqualTo(studyGroup1.getId().getId());
            assertThat(result.get(1).getId()).isEqualTo(studyGroup2.getId().getId());
        }

        private Pageable getPageable() {
            return new Pageable() {
                @Override
                public int getPageNumber() {
                    return 0;
                }

                @Override
                public int getPageSize() {
                    return 10;
                }

                @Override
                public long getOffset() {
                    return 0;
                }

                @Override
                public Sort getSort() {
                    return Sort.by(Sort.Direction.DESC, "createdAt");
                }

                @Override
                public Pageable next() {
                    return null;
                }

                @Override
                public Pageable previousOrFirst() {
                    return null;
                }

                @Override
                public Pageable first() {
                    return null;
                }

                @Override
                public Pageable withPage(int pageNumber) {
                    return null;
                }

                @Override
                public boolean hasPrevious() {
                    return false;
                }
            };
        }
    }
}
*/
