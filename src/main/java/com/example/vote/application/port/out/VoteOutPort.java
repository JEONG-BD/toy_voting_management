package com.example.vote.application.port.out;

import com.example.vote.domain.Vote;

public interface VoteOutPort {
    void castVote(Vote vote);
}
