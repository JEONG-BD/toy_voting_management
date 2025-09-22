package com.example.adapter.election.out.persistence;

import com.example.domain.election.ElectionStatus;
import org.springframework.stereotype.Component;

import com.example.domain.election.Election;

@Component
public class ElectionMapper {

    public Election mapToDomain(ElectionJPAEntity entity){
        return Election.withId(entity.getId(), 
        entity.getTitle(), 
        entity.getDescription(), 
        entity.getStartDate(), 
        entity.getEndDate(), 
        mapStatusToDomain(entity.getStatus()));
    }


    public ElectionJPAEntity mapToEntity(Election domain){
           return ElectionJPAEntity.builder()
                .id(domain.getId()==null? null: domain.getId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .status(ElectionMapper.mapStatusToEntity(domain.getStatus()))
                .build();
    }

    private static ElectionStatus mapStatusToDomain(ElectionStatusJPAEntity entityStatus){
        if(entityStatus == null) return null;
        switch(entityStatus){
            case PENDING: return ElectionStatus.PENDING;
            case IN_PROGRESS:    return ElectionStatus.IN_PROGRESS;
            case FINISHED:  return ElectionStatus.FINISHED;
            default: throw new IllegalArgumentException("Unknown status: " + entityStatus);
        }
    }

    private static ElectionStatusJPAEntity mapStatusToEntity(ElectionStatus domainStatus){
        if(domainStatus == null) return null;
        switch(domainStatus){
            case PENDING: return ElectionStatusJPAEntity.PENDING;
            case IN_PROGRESS:    return ElectionStatusJPAEntity.IN_PROGRESS;
            case FINISHED:  return ElectionStatusJPAEntity.FINISHED;
            default: throw new IllegalArgumentException("Unknown status: " + domainStatus);
        }
    }
}
