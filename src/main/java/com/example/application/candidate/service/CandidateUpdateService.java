package com.example.application.candidate.service;

import com.example.application.candidate.port.in.CandidateUpdateCommand;
import com.example.application.candidate.port.in.CandidateUpdateUseCase;
import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.candidate.Candidate;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;
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

        Candidate existing = candidateOutPort.findById(command.getId());

        Candidate updatedCandidate = existing.updated(
                command.getAge(),
                command.getName(),
                command.getParty(),
                election
        );

        return candidateOutPort.updateCandidate(updatedCandidate);
    }

}
