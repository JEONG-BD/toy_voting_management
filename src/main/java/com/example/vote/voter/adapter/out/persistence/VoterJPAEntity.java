package com.example.vote.voter.adapter.out.persistence;


import com.example.vote.election.adapter.out.persistence.ElectionJPAEntity;

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

    @ManyToOne(fetch = FetchType.LAZY) // Lazy 추천, N+1 문제 방지
    @JoinColumn(name = "election_id")  
    private ElectionJPAEntity election;

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

    public ElectionJPAEntity getElection(){
        return election;
    }

    
}
