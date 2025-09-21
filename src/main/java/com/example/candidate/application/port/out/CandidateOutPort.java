package com.example.candidate.application.port.out;

import com.example.candidate.application.port.in.CandidateFindCommand;
import com.example.candidate.domain.Candidate;

import java.util.List;

public interface CandidateOutPort {

    Candidate registerCandidate(Candidate candidate);
    Candidate updateCandidate(Candidate candidate);
    Candidate findById(Long id);
    List<Candidate> findByFilter(CandidateFindCommand command);
}
