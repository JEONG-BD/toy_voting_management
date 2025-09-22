package com.example.application.candidate.port.in;

import com.example.domain.candidate.Candidate;

public interface CandidateFindUseCase {

    Candidate registerCandidate(CandidateRegisterCommand command);
}
