package com.example.application.election.service;

import com.example.application.election.port.in.ElectionDeleteUseCase;
import com.example.application.election.port.out.ElectionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElectionDeleteService implements ElectionDeleteUseCase {

    private final ElectionOutPort electionOutPort;

    @Override
    public void delete(Long electionId) {
        electionOutPort.removeElection(electionId);
    }
}
