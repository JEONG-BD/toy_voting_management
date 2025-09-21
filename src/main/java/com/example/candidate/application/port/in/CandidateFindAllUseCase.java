package com.example.candidate.application.port.in;

import com.example.candidate.domain.Candidate;

import java.util.List;

public interface CandidateFindAllUseCase {

    List<Candidate> findAllCandidate(CandidateFindCommand command);
}
