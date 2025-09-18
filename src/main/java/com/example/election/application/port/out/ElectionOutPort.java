package com.example.election.application.port.out;

import com.example.election.domain.Election;

public interface ElectionOutPort {

    void registerElection(Election election);

    Election findById(Long electionId);

    Election updateElection(Election election);

    void removeElection(Long electionId);
}
