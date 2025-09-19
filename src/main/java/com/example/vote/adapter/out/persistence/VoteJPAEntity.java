package com.example.vote.adapter.out.persistence;

import com.example.candidate.adapter.out.persistence.CandidateJPAEntity;
import com.example.candidate.domain.Candidate;
import com.example.election.adapter.out.persistence.ElectionJPAEntity;
import com.example.election.domain.Election;
import com.example.voter.adapter.out.persistence.VoterJPAEntity;
import com.example.voter.domain.Voter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="vote")
public class VoteJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private VoterJPAEntity voter;

    private CandidateJPAEntity candidate;

    private ElectionJPAEntity election;

    public Long getId() {
        return id;
    }

    public VoterJPAEntity getVoter() {
        return voter;
    }

    public CandidateJPAEntity getCandidate() {
        return candidate;
    }

    public ElectionJPAEntity getElection() {
        return election;
    }
}
