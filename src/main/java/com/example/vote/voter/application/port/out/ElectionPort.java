package com.example.vote.voter.application.port.out;

import com.example.vote.voter.domain.Election;

public interface ElectionPort {

    void registerElection(Election election);
}
