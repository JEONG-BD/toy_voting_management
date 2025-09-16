package com.example.vote.voter.application.port.out;

import com.example.vote.voter.domain.Voter;

public interface RegisterVoterPort {
    void registerVoter(Voter voter);
}
