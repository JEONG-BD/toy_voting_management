package com.example.election.application.service;

import com.example.election.application.port.in.ElectionDeleteUseCase;
import com.example.election.application.port.out.ElectionOutPort;
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
