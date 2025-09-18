package com.example.voter.application.port.in;

import com.example.voter.domain.Voter;

public interface VoterFindByIdUseCase {

    Voter findByIdVoter(Long voterId);
}
