package com.example.vote.voter.application.port.in;

import java.time.LocalDateTime;

import lombok.Getter;

public class ElectionRegisterCommand {
    
    private final String title;
    private final String description;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

   public ElectionRegisterCommand(String title, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter (선택)
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
