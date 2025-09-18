package com.example.candidate.adapter.out.persistence;

import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CandidateAdatpter implements CandidateOutPort {

    private final CandidateMapper candidateMapper;
    private final CandidateRepository candidateRepository;

    @Override
    public Candidate registerCandidate(Candidate candidate) {
        CandidateJPAEntity candidateJPAEntity = candidateMapper.mapToDomain(candidate);
        candidateRepository.save(candidateJPAEntity);
        return candidateMapper.mapToEntity(candidateJPAEntity);
    }
}
