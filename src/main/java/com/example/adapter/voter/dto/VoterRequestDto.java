package com.example.adapter.voter.dto;

import lombok.ToString;

public record VoterRequestDto(String name, String email, Long electionId) {

}
