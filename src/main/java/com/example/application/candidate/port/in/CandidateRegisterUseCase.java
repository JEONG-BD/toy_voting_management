package com.example.application.candidate.port.in;

import com.example.domain.candidate.Candidate;

public interface CandidateRegisterUseCase {

    Candidate registerCandidate(CandidateRegisterCommand command);
}
