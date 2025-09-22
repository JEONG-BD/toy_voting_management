package com.example.adapter.vote.dto;

import com.example.domain.vote.Vote;

public record CastVoteResponseDto(Long voteId, long voterId, long candidateId) {

    public static CastVoteResponseDto from(Vote vote){
        return new CastVoteResponseDto(vote.getId(),
                vote.getVoter().getId(),
                vote.getCandidate().getId());
    }
}
