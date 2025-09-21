package com.example.adapter.vote.dto;

import com.example.domain.Vote;

public record CastVoteResponseDTO(Long voteId, long voterId, long candidateId) {

    public static CastVoteResponseDTO from(Vote vote){
        return new CastVoteResponseDTO(vote.getId(),
                vote.getVoter().getId(),
                vote.getCandidate().getId());
    }
}
