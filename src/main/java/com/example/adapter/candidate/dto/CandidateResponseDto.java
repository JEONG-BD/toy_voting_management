package com.example.adapter.candidate.dto;

import com.example.domain.candidate.Candidate;

public record CandidateResponseDto(long id, String name, int age, String party, long electionId) {


    public static CandidateResponseDto from(Candidate candidate){
        return new CandidateResponseDto(candidate.getId(),
                candidate.getName(),
                candidate.getAge(),
                candidate.getParty(),
                candidate.getElection().getId());
    }
}
