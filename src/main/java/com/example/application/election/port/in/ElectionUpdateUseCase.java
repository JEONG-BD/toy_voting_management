package com.example.application.election.port.in;

import com.example.domain.election.Election;

public interface ElectionUpdateUseCase {

    Election updateElection(ElectionUpdateCommand command);
}
