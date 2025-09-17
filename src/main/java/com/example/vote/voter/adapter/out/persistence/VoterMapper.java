package com.example.vote.voter.adapter.out.persistence;

import com.example.vote.election.adapter.out.persistence.ElectionMapper;
import com.example.vote.voter.domain.Voter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VoterMapper {

    private final ElectionMapper electionMapper;

    //Voter mapToDomain(VoterJPAEntity voterEntity){
    //    return Voter.withId(voterEntity.getId(),
    //            voterEntity.getName(),
    //            voterEntity.getEmail(),
    //            voterEntity.getHasVoted(),
    //            //electionMapper.mapToDomain(voterEntity.getElection()));
    //}
    //
    //VoterJPAEntity mapToEntity(Voter voter){
    //    return new VoterJPAEntity(voter.getId(),
    //            voter.getName(),
    //            voter.getEmail(),
    //            voter.getHasVoted(),
    //            //electionMapper.mapToEntity(voter.getElection()));
    //}
}
