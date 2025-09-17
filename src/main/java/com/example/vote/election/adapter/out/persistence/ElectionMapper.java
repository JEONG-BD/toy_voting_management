package com.example.vote.election.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.vote.voter.domain.Election;

@Component
public class ElectionMapper {

    Election mapToDomain(ElectionJPAEntity entity){
        return Election.withId(entity.getId(), 
        entity.getTitle(), 
        entity.getDescription(), 
        entity.getStartDate(), 
        entity.getEndDate(), 
        entity.getStatus());
    }

    ElectionJPAEntity mapToEntity(Election domain){
           return ElectionJPAEntity.builder()
                .id(domain.getId()==null? null: domain.getId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .status(domain.getStatus())
                .build();
    }
}
