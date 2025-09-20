package com.example.vote.adapter.dto;

import com.example.vote.domain.Vote;

public record CastVoteResponseDTO(Long voteId, long voterId, long candidateId) {

    public static CastVoteResponseDTO from(Vote vote){
        return new CastVoteResponseDTO(vote.getId(),
                vote.getVoter().getId(),
                vote.getCandidate().getId());
    }
}
