package com.example.application.election.port.in;

import com.example.domain.Election;

public interface ElectionFindByIdUseCase {

    Election findById(Long electionId);
}
