package com.example.vote.voter.application.port.out;

import com.example.vote.voter.domain.Election;

public interface ElectionOutPort {

    void registerElection(Election election);

    Election findById(Long electionId);

    Election updateElection(Election election);
}
