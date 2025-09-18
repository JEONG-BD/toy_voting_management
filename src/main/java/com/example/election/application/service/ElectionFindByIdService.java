package com.example.election.application.service;

import org.springframework.stereotype.Service;

import com.example.election.application.port.in.ElectionFindByIdUseCase;
import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;

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
