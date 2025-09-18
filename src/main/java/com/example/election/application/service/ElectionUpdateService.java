package com.example.election.application.service;

import com.example.election.application.port.in.ElectionUpdateCommand;
import com.example.election.application.port.in.ElectionUpdateUseCase;
import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
import com.example.election.domain.ElectionStatus;
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
        Election election = Election.withId(command.getId(),
                command.getTitle(),
                command.getDescription(),
                command.getStartDate(),
                command.getEndDate(),
                ElectionStatus.PENDING);

        return electionPort.updateElection(election);
    }
}
