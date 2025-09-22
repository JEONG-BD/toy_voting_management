package com.example.adapter.voter.out.persistence;

import com.example.adapter.election.out.persistence.ElectionMapper;
import com.example.adapter.voter.out.persistence.entity.VoterJPAEntity;
import com.example.domain.voter.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoterMapper {

    private final ElectionMapper electionMapper;

    public Voter mapToDomain(VoterJPAEntity voterEntity){

        return Voter.withId(voterEntity.getId(),
                voterEntity.getName(),
                voterEntity.getEmail(),
                voterEntity.getHasVoted(),
                electionMapper.mapToDomain(voterEntity.getElection()));
    }

    public VoterJPAEntity mapToEntity(Voter voter){
        return new VoterJPAEntity(
                voter.getId(),
                voter.getName(),
                voter.getEmail(),
                voter.getHasVoted(),
                electionMapper.mapToEntity(voter.getElection()));
    }
}
