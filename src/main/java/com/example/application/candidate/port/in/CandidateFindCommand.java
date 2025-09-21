package com.example.application.candidate.port.in;



public class CandidateFindCommand {
    private final String name;
    private final Integer age;
    private final String party;
    private final Long electionId;

    public CandidateFindCommand(String name, Integer age, String party, long electionId) {
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
