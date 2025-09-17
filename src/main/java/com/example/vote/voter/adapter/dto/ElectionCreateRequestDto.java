package com.example.vote.voter.adapter.dto;

import java.time.LocalDateTime;

public record ElectionCreateRequestDto(String name, String description, LocalDateTime startTime, LocalDateTime endTile, String status) {
    
}
