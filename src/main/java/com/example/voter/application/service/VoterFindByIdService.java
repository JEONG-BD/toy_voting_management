package com.example.voter.application.service;

import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
import com.example.election.domain.ElectionStatus;
import com.example.voter.application.port.in.VoterFindByIdUseCase;
import com.example.voter.application.port.in.VoterRegisterCommand;
import com.example.voter.application.port.in.VoterRegisterUseCase;
import com.example.voter.application.port.out.VoterOutPort;
import com.example.voter.domain.Voter;
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
