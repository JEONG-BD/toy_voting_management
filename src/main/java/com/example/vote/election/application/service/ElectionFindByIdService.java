package com.example.vote.election.application.service;

import org.springframework.stereotype.Service;

import com.example.vote.election.application.port.in.ElectionFindByIdUseCase;
import com.example.vote.election.application.port.out.ElectionOutPort;
import com.example.vote.voter.domain.Election;

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
