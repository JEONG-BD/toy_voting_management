package com.example.application.candidate.service;

import com.example.application.candidate.port.in.CandidateRegisterCommand;
import com.example.application.candidate.port.in.CandidateRegisterUseCase;
import com.example.application.candidate.port.out.CandidateOutPort;
import com.example.domain.candidate.Candidate;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateRegisterService implements CandidateRegisterUseCase {

    private final CandidateOutPort candidateOutPort;
    private final ElectionOutPort electionOutPort;

    @Override
    public Candidate registerCandidate(CandidateRegisterCommand command) {
        //TODO Validation
        Election election = electionOutPort.findById(command.getElectionId());
        Candidate candidate = Candidate.withOutId(command.getAge(), command.getName(), command.getParty(), election);
        return candidateOutPort.registerCandidate(candidate);
    }
}
