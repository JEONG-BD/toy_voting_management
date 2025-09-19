package com.example.candidate.application.port.in;

import com.example.candidate.domain.Candidate;

public interface CandidateFindUseCase {

    Candidate registerCandidate(CandidateRegisterCommand command);
}
