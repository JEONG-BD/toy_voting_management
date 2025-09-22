package com.example.adapter.election.out.persistence;

import com.example.application.election.port.in.ElectionFindFilterCommand;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ElectionCustomRepositoryImpl implements ElectionCustomRepository{

    private final JPAQueryFactory queryFactory;
    private final QElectionJPAEntity electionEntity = QElectionJPAEntity.electionJPAEntity;

    @Override
    public List<ElectionJPAEntity> findByFilter(ElectionFindFilterCommand command) {
        return queryFactory.selectFrom(electionEntity)
                .where(
                        nameLike(command.getName()),
                        descriptionLike(command.getDescription()),
                        startDateAfter(command.getStartDate()),
                        endDateBefore(command.getEndDate())

                )
                .fetch();
    }

    private BooleanExpression nameLike(String name) {
        return name != null ? electionEntity.title.contains(name) : null;
    }

    private BooleanExpression descriptionLike(String description) {
        return description != null ? electionEntity.description.contains(description) : null;
    }

    private BooleanExpression startDateAfter(LocalDateTime startDate) {
        return startDate != null ? electionEntity.startDate.goe(startDate) : null;
    }

    private BooleanExpression endDateBefore(LocalDateTime endDate) {
        return endDate != null ? electionEntity.endDate.loe(endDate) : null;
    }

    private BooleanExpression statusEq(String status) {
        if(status == null) return null;
        ElectionStatusJPAEntity enumStatus;
        try {
            enumStatus = ElectionStatusJPAEntity.valueOf(status);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return electionEntity.status.eq(enumStatus);
    }
}
