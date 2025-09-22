package com.example.application.vote.service;

import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.candidate.Candidate;
import com.example.application.vote.port.in.VoteCastCommand;
import com.example.application.vote.port.in.VoteCastUseCase;
import com.example.application.vote.port.out.VoteOutPort;
import com.example.domain.vote.Vote;
import com.example.application.voter.port.out.VoterOutPort;
import com.example.domain.voter.Voter;
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
