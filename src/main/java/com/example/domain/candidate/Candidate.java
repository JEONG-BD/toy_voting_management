package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Candidate {

    @Getter
    private final Long id;

    @Getter
    private final int age;

    @Getter
    private final String name;

    @Getter
    private final String party;

    @Getter
    private final int voteCount;

    @Getter
    private final Election election;

    public static Candidate withOutId(Integer age, String name, String party, Election election){
        if (age < 19) {
            throw new IllegalArgumentException("후보자는 19세 이상이어야 합니다.");
        }

        return new Candidate(null, age, name, party, 0, election);
    }

    public static Candidate withId(Long id, Integer age, String name, String party, int count, Election election){
        return new Candidate(id, age, name, party, count, election);
    }

}
