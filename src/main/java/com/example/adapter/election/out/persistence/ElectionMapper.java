package com.example.adapter.election.out.persistence;

import org.springframework.stereotype.Component;

import com.example.domain.Election;

@Component
public class ElectionMapper {

    public Election mapToDomain(ElectionJPAEntity entity){
        return Election.withId(entity.getId(), 
        entity.getTitle(), 
        entity.getDescription(), 
        entity.getStartDate(), 
        entity.getEndDate(), 
        entity.getStatus());
    }

    public ElectionJPAEntity mapToEntity(Election domain){
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
