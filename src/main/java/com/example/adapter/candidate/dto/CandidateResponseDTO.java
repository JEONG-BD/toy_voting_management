package com.example.adapter.candidate.dto;

import com.example.domain.Candidate;

public record CandidateResponseDTO(long id, String name, int age, String party, long electionId) {


    public static CandidateResponseDTO from(Candidate candidate){
        return new CandidateResponseDTO(candidate.getId(),
                candidate.getName(),
                candidate.getAge(),
                candidate.getParty(),
                candidate.getElection().getId());
    }
}
