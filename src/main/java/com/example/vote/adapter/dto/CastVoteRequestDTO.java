package com.example.vote.adapter.dto;

public record CastVoteRequestDTO(long voterId, long electionId, long candidateId) {
}
