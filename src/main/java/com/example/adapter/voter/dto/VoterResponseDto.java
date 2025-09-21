package com.example.adapter.voter.dto;

import com.example.domain.Voter;

public record VoterResponseDto(Long id, String name, String email) {

    public static VoterResponseDto from(Voter voter) {
        return new VoterResponseDto(
                voter.getId(),
                voter.getName(),
                voter.getEmail()
                );
    }
}
