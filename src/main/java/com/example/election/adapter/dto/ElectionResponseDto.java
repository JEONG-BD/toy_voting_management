package com.example.election.adapter.dto;

import com.example.election.domain.Election;

import java.time.LocalDateTime;

public record ElectionResponseDto(
        Long id,
        String title,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String status
) {

    public static ElectionResponseDto from(Election election) {
        return new ElectionResponseDto(
                election.getId(),
                election.getTitle(),
                election.getDescription(),
                election.getStartDate(),
                election.getEndDate(),
                election.getStatus().name() // Enum → String
        );
    }
}
