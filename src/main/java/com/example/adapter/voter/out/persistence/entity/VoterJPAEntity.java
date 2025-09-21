package com.example.adapter.voter.out.persistence.entity;


import com.example.adapter.election.out.persistence.ElectionJPAEntity;

import com.example.adapter.vote.out.persistence.VoteJPAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "voter")
public class VoterJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private boolean hasVoted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "election_id")  
    private ElectionJPAEntity election;

    @OneToMany(mappedBy = "voter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteJPAEntity> votes = new ArrayList<>();

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

    public VoterJPAEntity(Long id, String name, String email, boolean hasVoted, ElectionJPAEntity election) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hasVoted = hasVoted;
        this.election = election;
    }
}
