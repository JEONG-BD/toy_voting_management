package com.example.candidate.adapter.dto;

import com.example.candidate.domain.Candidate;

public record CandidateResponseDTO(long id, String name, int age, String party, long electionId) {


    public static CandidateResponseDTO from(Candidate candidate){
        return new CandidateResponseDTO(candidate.getId(),
                candidate.getName(),
                candidate.getAge(),
                candidate.getParty(),
                candidate.getElection().getId());
    }
}
