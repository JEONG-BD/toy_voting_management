package com.example.voter.application.port.out;

import com.example.voter.domain.Voter;

public interface VoterOutPort {
    void registerVoter(Voter voter);
    Voter updateVoter(Voter voter);
}
