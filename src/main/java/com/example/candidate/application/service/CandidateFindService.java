package com.example.candidate.application.service;

import com.example.candidate.application.port.in.CandidateFindAllUseCase;
import com.example.candidate.application.port.in.CandidateFindCommand;
import com.example.candidate.application.port.in.CandidateRegisterCommand;
import com.example.candidate.application.port.in.CandidateRegisterUseCase;
import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
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
