package com.example.vote.application.port.in;

import com.example.election.domain.Election;

public class VoteCastCommand {
    private final Long voterId;
    private final Long candidateId;

    public VoteCastCommand(Long voterId, Long candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public Long getVoterId() {
        return voterId;
    }

    public Long getCandidateId() {
        return candidateId;
    }
}
