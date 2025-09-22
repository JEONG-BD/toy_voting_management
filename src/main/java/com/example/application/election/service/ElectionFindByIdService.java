package com.example.application.election.service;

import org.springframework.stereotype.Service;

import com.example.application.election.port.in.ElectionFindByIdUseCase;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ElectionFindByIdService implements ElectionFindByIdUseCase{

    private final ElectionOutPort electionPort;
    
    @Override
    public Election findById(Long electionId) {
        Election election =electionPort.findById(electionId);
        return election;
    }

}
