package com.example.vote.election.application.service;

import com.example.vote.election.application.port.in.ElectionDeleteUseCase;
import com.example.vote.election.application.port.out.ElectionOutPort;
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
