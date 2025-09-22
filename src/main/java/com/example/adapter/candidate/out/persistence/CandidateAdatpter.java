package com.example.adapter.candidate.out.persistence;

import com.example.application.candidate.port.in.CandidateFindCommand;
import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.candidate.Candidate;
import com.example.adapter.election.out.persistence.ElectionJPAEntity;
import com.example.adapter.election.out.persistence.ElectionMapper;
import com.example.adapter.election.out.persistence.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class CandidateAdatpter implements CandidateOutPort {

    private final CandidateMapper candidateMapper;
    private final ElectionMapper electionMapper;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    @Override
    public Candidate registerCandidate(Candidate candidate) {
        CandidateJPAEntity candidateJPAEntity = candidateMapper.mapToEntity(candidate);
        candidateRepository.save(candidateJPAEntity);
        return candidateMapper.mapToDomain(candidateJPAEntity);
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

        return candidateMapper.mapToDomain(candidateJPAEntity);
    }

    @Override
    public Candidate findById(Long id) {
        CandidateJPAEntity candidateJPAEntity = candidateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("not existing"));

        return candidateMapper.mapToDomain(candidateJPAEntity);
    }

    @Override
    public List<Candidate> findByFilter(CandidateFindCommand command) {
        return candidateRepository.findByFilter(command)
                .stream()
                .map(candidateMapper::mapToDomain)
                .toList();
    }
}
