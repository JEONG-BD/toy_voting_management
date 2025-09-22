package com.example.application.voter.port.out;

import com.example.domain.voter.Voter;

public interface VoterOutPort {
    void registerVoter(Voter voter);
    Voter updateVoter(Voter voter);
    Voter findByIdVoter(Long voterId);
}
