package com.example.application.voter.port.in;

import com.example.domain.voter.Voter;

public interface VoterFindByIdUseCase {

    Voter findByIdVoter(Long voterId);
}
