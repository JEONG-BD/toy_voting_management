package com.example.vote.voter.application.service;

import org.springframework.stereotype.Service;

import com.example.vote.voter.application.port.in.ElectionRegisterCommand;
import com.example.vote.voter.application.port.in.ElectionRegisterUseCase;

import com.example.vote.voter.application.port.out.ElectionPort;
import com.example.vote.voter.domain.Election;
import com.example.vote.voter.domain.ElectionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterElectionService implements ElectionRegisterUseCase {

    
    private final ElectionPort electionPort;

    @Override
    public boolean registerElection(ElectionRegisterCommand command) {
        Election election = new Election(null, command.getTitle(), 
        command.getDescription(), command.getStartDate(), command.getEndDate(), ElectionStatus.PENDING);
        electionPort.registerElection(election);
        return false;
    }

}
