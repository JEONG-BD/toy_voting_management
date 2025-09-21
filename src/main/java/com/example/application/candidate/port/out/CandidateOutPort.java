package com.example.application.candidate.port.out;

import com.example.application.candidate.port.in.CandidateFindCommand;
import com.example.domain.Candidate;

import java.util.List;

public interface CandidateOutPort {

    Candidate registerCandidate(Candidate candidate);
    Candidate updateCandidate(Candidate candidate);
    Candidate findById(Long id);
    List<Candidate> findByFilter(CandidateFindCommand command);
}
