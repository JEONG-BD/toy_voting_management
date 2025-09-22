package com.example.application.vote.port.out;

import com.example.domain.vote.Vote;

public interface VoteOutPort {
    Vote castVote(Vote vote);
}
