package com.example.voter.adapter.out.persistence;


import com.example.election.adapter.out.persistence.ElectionJPAEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
