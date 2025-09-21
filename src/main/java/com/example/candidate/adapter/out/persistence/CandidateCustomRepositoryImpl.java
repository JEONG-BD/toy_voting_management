package com.example.candidate.adapter.out.persistence;

import com.example.candidate.application.port.in.CandidateFindCommand;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class CandidateCustomRepositoryImpl implements CandidateCustomRepository {

    private final JPAQueryFactory queryFactory;
    private final QCandidateJPAEntity candidate = QCandidateJPAEntity.candidateJPAEntity;

    @Override
    public List<CandidateJPAEntity> findByFilter(CandidateFindCommand command) {
        return queryFactory.selectFrom(candidate)
                .where(
                        nameEq(command.getName()),
                        ageEq(command.getAge()),
                        partyEq(command.getParty()),
                        candidate.election.id.eq(command.getElectionId())
                )
                .fetch();
    }

    private BooleanExpression nameEq(String name) {
        return name != null ? candidate.name.eq(name) : null;
    }

    private BooleanExpression ageEq(Integer age) {
        return age != null ? candidate.age.eq(age) : null;
    }

    private BooleanExpression partyEq(String party) {
        return party != null ? candidate.party.eq(party) : null;
    }
}
