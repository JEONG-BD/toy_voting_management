package com.example.application.candidate.port.in;

import com.example.domain.Candidate;

public interface CandidateRegisterUseCase {

    Candidate registerCandidate(CandidateRegisterCommand command);
}
