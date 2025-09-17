package com.example.vote.election.application.port.in;

import com.example.vote.voter.domain.Election;

public interface ElectionUpdateUseCase {

    Election updateElection(ElectionUpdateCommand command);
}
