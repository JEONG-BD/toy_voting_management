package com.example.adapter.vote.out.persistence;

import com.example.adapter.candidate.out.persistence.CandidateJPAEntity;
import com.example.adapter.candidate.out.persistence.CandidateMapper;
import com.example.domain.Vote;
import com.example.adapter.voter.out.persistence.entity.VoterJPAEntity;
import com.example.adapter.voter.out.persistence.VoterMapper;
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
