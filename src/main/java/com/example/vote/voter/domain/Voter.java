package com.example.vote.voter.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Voter {

    @Getter
    private final Long id;

    @Getter
    private final String name;

    @Getter
    private final String email;

    @Getter
    private final Boolean hasVoted;

    @Getter
    private final Election election;

    public static Voter withoutId(String name, String email, Election election){
        return new Voter(null, name, email, false, election);
    }

    public static Voter withId(Long id, String name, String email, Boolean hasVoted, Election election){
        return new Voter(null, name, email, hasVoted, election);
    }

}
