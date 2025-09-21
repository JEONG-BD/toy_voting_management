package com.example.application.candidate.service;

import com.example.application.candidate.port.in.CandidateUpdateCommand;
import com.example.application.candidate.port.in.CandidateUpdateUseCase;
import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.Candidate;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.Election;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateUpdateService implements CandidateUpdateUseCase {

    private final CandidateOutPort candidateOutPort;
    private final ElectionOutPort electionOutPort;

    @Override
    public Candidate updateCandidate(CandidateUpdateCommand command) {
        Election election = electionOutPort.findById(command.getElectionId());

        Candidate candidate = Candidate.withId(command.getId(),
                command.getAge(),
                command.getName(),
                command.getParty(),
                0,
                election);
        return candidateOutPort.updateCandidate(candidate);
    }

}
