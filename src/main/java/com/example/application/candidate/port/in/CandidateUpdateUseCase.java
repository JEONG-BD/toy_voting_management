package com.example.application.candidate.port.in;

import com.example.domain.Candidate;

public interface CandidateUpdateUseCase {

    Candidate updateCandidate(CandidateUpdateCommand command);
}
