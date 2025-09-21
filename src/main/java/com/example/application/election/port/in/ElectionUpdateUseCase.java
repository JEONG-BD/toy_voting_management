package com.example.application.election.port.in;

import com.example.domain.Election;

public interface ElectionUpdateUseCase {

    Election updateElection(ElectionUpdateCommand command);
}
