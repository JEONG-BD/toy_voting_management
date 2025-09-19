package com.example.vote.application.port.in;

import com.example.election.domain.Election;

public class VoteCastCommand {
    private final Long voterId;
    private final Long electionId;
    private final Long candiddateId;

    public VoteCastCommand(Long voterId, Long electionId, Long candiddateId) {
        this.voterId = voterId;
        this.electionId = electionId;
        this.candiddateId = candiddateId;
    }

    public Long getVoterId() {
        return voterId;
    }

    public Long getElectionId() {
        return electionId;
    }

    public Long getCandiddateId() {
        return candiddateId;
    }
}
