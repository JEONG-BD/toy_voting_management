package com.example.application.candidate.port.in;

import com.example.domain.candidate.Candidate;

public interface CandidateUpdateUseCase {

    Candidate updateCandidate(CandidateUpdateCommand command);
}
