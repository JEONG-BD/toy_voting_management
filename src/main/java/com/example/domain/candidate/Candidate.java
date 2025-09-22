package com.example.domain.candidate;


import com.example.domain.candidate.exception.UnderAgeCandidateException;
import com.example.domain.election.Election;
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
            throw new UnderAgeCandidateException("Candidate must be at least 19 years old. Age: " + age);
        }

        return new Candidate(null, age, name, party, 0, election);
    }

    public static Candidate withId(Long id, Integer age, String name, String party, int count, Election election){
        return new Candidate(id, age, name, party, count, election);
    }

    public Candidate updated(Integer newAge, String newName, String newParty, Election newElection) {
        return new Candidate(
                this.id,
                newAge != null ? validateAndReturnAge(newAge) : this.age,
                newName != null ? newName : this.name,
                newParty != null ? newParty : this.party,
                0,
                newElection != null ? newElection : this.election
        );
    }


    private static void validateAge(Integer age) {
        if(age != null && age < 19) {
            throw new UnderAgeCandidateException("Candidate must be at least 19 years old. Age: " + age);
        }
    }

    private static Integer validateAndReturnAge(Integer age) {
        validateAge(age);
        return age;
    }

}
