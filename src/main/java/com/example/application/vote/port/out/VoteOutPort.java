package com.example.application.vote.port.out;

import com.example.domain.Vote;

public interface VoteOutPort {
    Vote castVote(Vote vote);
}
