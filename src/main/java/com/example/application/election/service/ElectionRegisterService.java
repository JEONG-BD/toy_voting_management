package com.example.application.election.service;

import org.springframework.stereotype.Service;

import com.example.application.election.port.in.ElectionRegisterCommand;
import com.example.application.election.port.in.ElectionRegisterUseCase;

import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;
import com.example.domain.election.ElectionStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElectionRegisterService implements ElectionRegisterUseCase {

    
    private final ElectionOutPort electionPort;


    @Override
    public boolean registerElection(ElectionRegisterCommand command) {
        Election election = new Election(null, command.getTitle(), 
        command.getDescription(), command.getStartDate(), command.getEndDate(), ElectionStatus.PENDING);
        electionPort.registerElection(election);
        return false;
    }

}
