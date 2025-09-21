package com.example.application.voter.port.in;

import lombok.ToString;


@ToString
public class VoterRegisterCommand {

    private final String name;
    private final String email;
    private final Long electionId;

    public VoterRegisterCommand(String name, String email, Long electionId) {
        this.name = name;
        this.email = email;
        this.electionId = electionId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getElectionId() {
        return electionId;
    }
}

