package com.example.vote.voter.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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


    public static Voter withoutId(String name, String email){
        return new Voter(null, name, email, false);
    }

    public static Voter withId(Long id, String name, String email, Boolean hasVoted){
        return new Voter(null, name, email, hasVoted);
    }

}
