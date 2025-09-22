package com.example.application.election.service;

import com.example.application.election.port.in.ElectionUpdateCommand;
import com.example.application.election.port.in.ElectionUpdateUseCase;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;
import com.example.domain.election.ElectionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElectionUpdateService implements ElectionUpdateUseCase {

    
    private final ElectionOutPort electionPort;

    @Override
    @Transactional
    public Election updateElection(ElectionUpdateCommand command) {
        electionPort.findById(command.getId());



        Election election = Election.withId(command.getId(),
                command.getTitle(),
                command.getDescription(),
                command.getStartDate(),
                command.getEndDate(),
                ElectionStatus.PENDING);

        return electionPort.updateElection(election);
    }
}
