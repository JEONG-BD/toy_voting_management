package com.example.vote.voter.adapter.out.persistence;

import com.example.vote.voter.domain.ElectionStatus;
import org.springframework.stereotype.Component;

import com.example.vote.voter.application.port.out.ElectionOutPort;
import com.example.vote.voter.domain.Election;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ElectionAdapter implements ElectionOutPort{

    private final ElectionRepository electionRepository;
    private final ElectionMapper electionMapper;

    @Override
    public void registerElection(Election election) {
        ElectionJPAEntity entity = electionMapper.mapToEntity(election);
        electionRepository.save(entity);
    }

    @Override
    public Election findById(Long electionId) {
        ElectionJPAEntity entity = electionRepository.findById(electionId)
                .orElseThrow(() -> new NoSuchElementException("Election not found with id " + electionId));

        return  electionMapper.mapToDomain(entity);
    }

    @Override
    public Election updateElection(Election election) {
        ElectionJPAEntity existing = electionRepository.findById(election.getId())
                .orElseThrow(() -> new NoSuchElementException("Election not found"));
        existing.update(
                election.getTitle(),
                election.getDescription(),
                election.getStartDate(),
                election.getEndDate(),
                ElectionStatus.PENDING);

        return electionMapper.mapToDomain(existing);
    }
}   
 
