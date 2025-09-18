package com.example.candidate.application.port.in;

import lombok.RequiredArgsConstructor;


public class CandateRegisterCommand {
    private final String name;
    private final int age;
    private final String party;
    private final long electionId;

    public CandateRegisterCommand(String name, Integer age, String party, long electionId) {
        this.name = name;
        this.age = age;
        this.party = party;
        this.electionId = electionId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getParty() {
        return party;
    }

    public long getElectionId() {
        return electionId;
    }
}
