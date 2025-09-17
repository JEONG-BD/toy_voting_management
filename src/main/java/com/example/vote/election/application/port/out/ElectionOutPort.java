package com.example.vote.election.application.port.out;

import com.example.vote.voter.domain.Election;

public interface ElectionOutPort {

    void registerElection(Election election);

    Election findById(Long electionId);

    Election updateElection(Election election);

    void removeElection(Long electionId);
}
