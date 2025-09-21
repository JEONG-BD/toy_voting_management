package com.example.vote.adapter.out.persistence;

import com.example.candidate.adapter.out.persistence.CandidateJPAEntity;
import com.example.election.adapter.out.persistence.ElectionJPAEntity;
import com.example.voter.adapter.out.persistence.entity.VoterJPAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vote")
public class VoteJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="voter_id")
    private VoterJPAEntity voter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="candidate_id")
    private CandidateJPAEntity candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="election_id")
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
