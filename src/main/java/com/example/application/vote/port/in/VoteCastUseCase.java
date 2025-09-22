package com.example.application.vote.port.in;

import com.example.domain.vote.Vote;

public interface VoteCastUseCase {

    Vote castVote(VoteCastCommand command);
}
