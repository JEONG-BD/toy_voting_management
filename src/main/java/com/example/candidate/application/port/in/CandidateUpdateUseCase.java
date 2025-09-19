package com.example.candidate.application.port.in;

import com.example.candidate.domain.Candidate;

public interface CandidateUpdateUseCase {

    Candidate updateCandidate(CandidateUpdateCommand command);
}
