package com.example.candidate.adapter.out.persistence;

import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import com.example.election.adapter.out.persistence.ElectionJPAEntity;
import com.example.election.adapter.out.persistence.ElectionMapper;
import com.example.election.adapter.out.persistence.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CandidateAdatpter implements CandidateOutPort {

    private final CandidateMapper candidateMapper;
    private final ElectionMapper electionMapper;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    @Override
    public Candidate registerCandidate(Candidate candidate) {
        CandidateJPAEntity candidateJPAEntity = candidateMapper.mapToDomain(candidate);
        candidateRepository.save(candidateJPAEntity);
        return candidateMapper.mapToEntity(candidateJPAEntity);
    }

    @Override
    @Transactional
    public Candidate updateCandidate(Candidate candidate) {
        CandidateJPAEntity candidateJPAEntity = candidateRepository.findById(candidate.getId())
                .orElseThrow(() -> new NoSuchElementException("not existing candidate"));
        ElectionJPAEntity electionEntity = electionMapper.mapToEntity(candidate.getElection());
        candidateJPAEntity.updateEntity(candidate.getId(),
                candidate.getName(),
                candidate.getAge(),
                candidate.getParty(),
                candidate.getVoteCount(),
                electionEntity);

        return candidateMapper.mapToEntity(candidateJPAEntity);
    }
}
