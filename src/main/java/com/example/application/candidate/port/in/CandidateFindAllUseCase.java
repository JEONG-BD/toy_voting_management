package com.example.application.candidate.port.in;

import com.example.domain.candidate.Candidate;

import java.util.List;

public interface CandidateFindAllUseCase {

    List<Candidate> findAllCandidate(CandidateFindCommand command);
}
