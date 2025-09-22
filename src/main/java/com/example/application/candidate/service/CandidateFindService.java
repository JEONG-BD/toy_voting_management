package com.example.application.candidate.service;

import com.example.application.candidate.port.in.CandidateFindAllUseCase;
import com.example.application.candidate.port.in.CandidateFindCommand;
import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.candidate.Candidate;
import com.example.application.election.port.out.ElectionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateFindService implements CandidateFindAllUseCase {

    private final CandidateOutPort candidateOutPort;
    private final ElectionOutPort electionOutPort;

    @Override
    public List<Candidate> findAllCandidate(CandidateFindCommand command) {
        return candidateOutPort.findByFilter(command);
    }
}
