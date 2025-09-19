package com.example.candidate.application.service;

import com.example.candidate.application.port.in.CandidateUpdateCommand;
import com.example.candidate.application.port.in.CandidateUpdateUseCase;
import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
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
