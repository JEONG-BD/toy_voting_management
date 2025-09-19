package com.example.vote.adapter.out.persistence;

import com.example.candidate.adapter.out.persistence.CandidateMapper;
import com.example.election.adapter.out.persistence.ElectionMapper;
import com.example.vote.domain.Vote;
import com.example.voter.adapter.out.persistence.VoterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteMapper {

    private final VoterMapper voterMapper;
    private final ElectionMapper electionMapper;
    private final CandidateMapper candidateMapper;


}
