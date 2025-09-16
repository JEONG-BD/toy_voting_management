package com.example.vote.voter.adapter.out.persistence;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VoterJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private boolean hasVoted;

    private Long voteId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean getHasVoted() {
        return hasVoted;
    }

    public Long getVoteId() {
        return voteId;
    }
}
