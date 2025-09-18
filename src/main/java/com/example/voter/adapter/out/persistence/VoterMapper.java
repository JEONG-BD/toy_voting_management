package com.example.voter.adapter.out.persistence;

import com.example.election.adapter.out.persistence.ElectionMapper;
import com.example.voter.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoterMapper {

    private final ElectionMapper electionMapper;

    Voter mapToDomain(VoterJPAEntity voterEntity){

        return Voter.withId(voterEntity.getId(),
                voterEntity.getName(),
                voterEntity.getEmail(),
                voterEntity.getHasVoted(),
                electionMapper.mapToDomain(voterEntity.getElection()));
    }

    VoterJPAEntity mapToEntity(Voter voter){
        return new VoterJPAEntity(
                voter.getId(),
                voter.getName(),
                voter.getEmail(),
                voter.getHasVoted(),
                electionMapper.mapToEntity(voter.getElection()));
    }
}
