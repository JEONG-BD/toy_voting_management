package com.example.vote.application.service;

import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import com.example.vote.adapter.out.persistence.VoteAdapter;
import com.example.vote.application.port.in.VoteCastCommand;
import com.example.vote.application.port.in.VoteCastUseCase;
import com.example.vote.application.port.out.VoteOutPort;
import com.example.vote.domain.Vote;
import com.example.voter.application.port.out.VoterOutPort;
import com.example.voter.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteCastService implements VoteCastUseCase {

    private final VoteOutPort voteOutPort;
    private final VoterOutPort voterOutPort;
    private final CandidateOutPort candidateOutPort;
    @Override
    public Vote castVote(VoteCastCommand command) {

        Voter voter = voterOutPort.findByIdVoter(command.getVoterId());
        Candidate candidate = candidateOutPort.findById(command.getCandidateId());
        Vote vote = Vote.withoutId(null,
                voter,
                candidate);
        Vote result = voteOutPort.castVote(vote);
        return result;
    }
}
