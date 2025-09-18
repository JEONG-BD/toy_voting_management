package com.example.election.application.port.in;

import com.example.election.domain.Election;

public interface ElectionUpdateUseCase {

    Election updateElection(ElectionUpdateCommand command);
}
