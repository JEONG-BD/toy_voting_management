package com.example.voter.adapter.dto;

import lombok.ToString;

public record VoterRequestDto(String name, String email, Long electionId) {

}
