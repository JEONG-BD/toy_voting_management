package com.example.candidate.application.port.out;

import com.example.candidate.domain.Candidate;

public interface CandidateOutPort {

    Candidate registerCandidate(Candidate candidate);
}
