package com.example.application.candidate.port.in;

import com.example.domain.Candidate;

public interface CandidateFindUseCase {

    Candidate registerCandidate(CandidateRegisterCommand command);
}
