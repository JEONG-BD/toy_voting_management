package com.example.adapter.election.dto;

import java.time.LocalDateTime;

public record ElectionRequestDto(Long id,
                                 String title,
                                 String description,
                                 LocalDateTime startDate,
                                 LocalDateTime endDate,
                                 String status) {
    
}
