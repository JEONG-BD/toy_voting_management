package com.example.application.voter.service;

import com.example.application.election.port.out.ElectionOutPort;
import com.example.application.voter.port.in.VoterFindByIdUseCase;
import com.example.application.voter.port.out.VoterOutPort;
import com.example.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterFindByIdService implements VoterFindByIdUseCase {

    private final VoterOutPort voterOutPort;
    private final ElectionOutPort electionOutPort;

    @Override
    public Voter findByIdVoter(Long voterId) {
        return voterOutPort.findByIdVoter(voterId);
    }
}
