package com.example.application.candidate.port.in;

public class CandidateUpdateCommand {

    private final long id;
    private final String name;
    private final int age;
    private final String party;
    private final long electionId;

    public CandidateUpdateCommand(long id, String name, int age, String party, long electionId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.party = party;
        this.electionId = electionId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getParty() {
        return party;
    }

    public long getElectionId() {
        return electionId;
    }
}
