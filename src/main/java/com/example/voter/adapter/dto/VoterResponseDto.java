package com.example.voter.adapter.dto;

import com.example.election.adapter.dto.ElectionResponseDto;
import com.example.election.domain.Election;
import com.example.voter.domain.Voter;

public record VoterResponseDto(Long id, String name, String email) {

    public static VoterResponseDto from(Voter voter) {
        return new VoterResponseDto(
                voter.getId(),
                voter.getName(),
                voter.getEmail()
                );
    }
}
