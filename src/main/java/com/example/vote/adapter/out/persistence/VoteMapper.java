package com.example.vote.adapter.out.persistence;

import com.example.candidate.adapter.out.persistence.CandidateJPAEntity;
import com.example.candidate.adapter.out.persistence.CandidateMapper;
import com.example.election.adapter.out.persistence.ElectionMapper;
import com.example.vote.domain.Vote;
import com.example.voter.adapter.out.persistence.VoterJPAEntity;
import com.example.voter.adapter.out.persistence.VoterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteMapper {

    private final VoterMapper voterMapper;
    private final CandidateMapper candidateMapper;

    public VoteJPAEntity mapToEntity(Vote vote){
        VoterJPAEntity voterJPAEntity = voterMapper.mapToEntity(vote.getVoter());
        CandidateJPAEntity candidateJPAEntity = candidateMapper.mapToEntity(vote.getCandidate());
        return new VoteJPAEntity(null, voterJPAEntity, candidateJPAEntity, voterJPAEntity.getElection());
    }


    public Vote mapToDomain(VoteJPAEntity voteJPAEntity){

        return new Vote(voteJPAEntity.getId(),
                voterMapper.mapToDomain(voteJPAEntity.getVoter()),
                candidateMapper.mapToDomain(voteJPAEntity.getCandidate()));

   }
}
