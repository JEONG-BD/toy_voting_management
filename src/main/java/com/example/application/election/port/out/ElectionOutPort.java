package com.example.application.election.port.out;

import com.example.domain.Election;

public interface ElectionOutPort {

    void registerElection(Election election);

    Election findById(Long electionId);

    Election updateElection(Election election);

    void removeElection(Long electionId);
}
