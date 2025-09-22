package com.example.application.election.service;

import com.example.application.election.port.in.ElectionFindAllUseCase;
import com.example.application.election.port.in.ElectionFindFilterCommand;
import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.election.Election;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionFindAllService implements ElectionFindAllUseCase {

    private final ElectionOutPort electionOutPort;

    @Override
    public List<Election> findByFilter(ElectionFindFilterCommand command) {
        return electionOutPort.findByFilter(command);
    }
}
