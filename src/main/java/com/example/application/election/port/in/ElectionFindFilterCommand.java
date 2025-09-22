package com.example.application.election.port.in;

import java.time.LocalDateTime;

public class ElectionFindFilterCommand {

    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String status;

    public ElectionFindFilterCommand(Long id, String name, String description, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public String getStatus() {
        return status;
    }
}
