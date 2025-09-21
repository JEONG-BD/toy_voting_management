package com.example.application.vote.port.in;

import com.example.domain.Vote;

public interface VoteCastUseCase {

    Vote castVote(VoteCastCommand command);
}
