package com.example.adapter.candidate.dto;

public record CandidateUpdateRequestDto(long id, String name, int age, String party, long electionId) {
}
