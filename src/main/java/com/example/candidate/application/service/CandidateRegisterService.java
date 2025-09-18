package com.example.candidate.application.service;

import com.example.candidate.application.port.in.CandateRegisterCommand;
import com.example.candidate.application.port.in.CandidateRegisterUseCase;
import com.example.candidate.application.port.out.CandidateOutPort;
import com.example.candidate.domain.Candidate;
import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
import com.example.election.domain.ElectionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateRegisterService implements CandidateRegisterUseCase {

    private final CandidateOutPort candidateOutPort;
    private final ElectionOutPort electionOutPort;

    @Override
    public Candidate registerCandidate(CandateRegisterCommand command) {
        Election election = electionOutPort.findById(command.getElectionId());
        Candidate candidate = Candidate.withOutId(command.getAge(), command.getName(), command.getParty(), election);
        return candidateOutPort.registerCandidate(candidate);
    }
}
