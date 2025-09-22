package com.example.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Vote {

    private final Long id;

    private final Voter voter;

    //private final Election election;

    private final Candidate candidate;

    public static Vote withoutId(Long id, Voter voter, Candidate candidate){
        return new Vote(null, voter, candidate);
    }

    public static Vote withId(Long id, Voter voter, Candidate candidate){
        return new Vote(id, voter, candidate);
    }

    public Long getId() {
        return id;
    }

    public Voter getVoter() {
        return voter;
    }


    public Candidate getCandidate() {
        return candidate;
    }
}
