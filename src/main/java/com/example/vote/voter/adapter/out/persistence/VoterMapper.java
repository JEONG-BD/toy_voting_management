package com.example.vote.voter.adapter.out.persistence;

import com.example.vote.voter.domain.Voter;

public class VoterMapper {

    Voter mapToDomainEntity(VoterJPAEntity voterEntity){
        return Voter.withId(voterEntity.getId(),
                voterEntity.getName(),
                voterEntity.getEmail(),
                voterEntity.getHasVoted());
    }

    VoterJPAEntity mapToDomainEntity(Voter voter){
        return new VoterJPAEntity(voter.getId(),  voter.getName(),
                voter.getEmail(),
                voter.getHasVoted(), 1L);
    }
}
