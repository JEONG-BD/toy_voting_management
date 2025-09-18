package com.example.candidate.adapter.out.persistence;

import com.example.candidate.domain.Candidate;
import com.example.election.adapter.out.persistence.ElectionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CandidateMapper {

    private final ElectionMapper electionMapper;
    public CandidateJPAEntity mapToDomain(Candidate candidate){
        return new CandidateJPAEntity(
                candidate.getId(),
                candidate.getName(),
                candidate.getParty(),
                candidate.getAge(),
                candidate.getVoteCount(),
                electionMapper.mapToEntity(candidate.getElection()));

    }

    public Candidate mapToEntity(CandidateJPAEntity entity){
        return Candidate.withId(
                entity.getId(),
                entity.getAge(),
                entity.getName(),
                entity.getParty(),
                entity.getVoteCount(),
                electionMapper.mapToDomain(entity.getElection()));

    }

}
