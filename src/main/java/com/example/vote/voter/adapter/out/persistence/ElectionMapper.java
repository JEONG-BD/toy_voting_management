package com.example.vote.voter.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.vote.voter.domain.Election;
import lombok.NoArgsConstructor;

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
                .id(null)
                .title(domain.getTitle())
                .description(domain.getDescription())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .status(domain.getStatus())
                .build();
    }
}
