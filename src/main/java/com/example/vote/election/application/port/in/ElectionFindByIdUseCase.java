package com.example.vote.election.application.port.in;

import com.example.vote.voter.domain.Election;

public interface ElectionFindByIdUseCase {

    Election findById(Long electionId);
}
