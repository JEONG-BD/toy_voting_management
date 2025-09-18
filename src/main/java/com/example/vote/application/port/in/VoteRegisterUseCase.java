package com.example.vote.application.port.in;

import com.example.vote.domain.Vote;

public interface VoteRegisterUseCase {

    Vote registerVote(VoteRegisterCommand command);
}
