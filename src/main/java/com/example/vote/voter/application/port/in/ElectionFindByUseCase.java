package com.example.vote.voter.application.port.in;

import com.example.vote.voter.domain.Election;

public interface ElectionFindByUseCase {

    Election findById(Long electionId);
}
