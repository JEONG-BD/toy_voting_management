package com.example.candidate.adapter.out.persistence;

import com.example.election.adapter.out.persistence.ElectionJPAEntity;
import com.example.election.domain.Election;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
public class CandidateJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String party;

    private Integer age;

    private Integer voteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "election_id")
    private ElectionJPAEntity election;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public ElectionJPAEntity getElection() {
        return election;
    }
}
