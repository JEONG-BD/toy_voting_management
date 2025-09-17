package com.example.vote.voter.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.vote.voter.application.port.out.ElectionPort;
import com.example.vote.voter.domain.Election;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ElectionAdapter implements ElectionPort{

    private final ElectionRepository electionRepository;
    private final ElectionMapper electionMapper;

    @Override
    public void registerElection(Election election) {
        ElectionJPAEntity entity = electionMapper.mapToEntity(election);
        electionRepository.save(entity);
    }
}   
 
