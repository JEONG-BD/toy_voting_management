package com.example.application.voter.service;

import com.example.application.election.port.out.ElectionOutPort;
import com.example.domain.Election;
import com.example.domain.ElectionStatus;
import com.example.application.voter.port.in.VoterRegisterCommand;
import com.example.application.voter.port.in.VoterRegisterUseCase;
import com.example.application.voter.port.out.VoterOutPort;
import com.example.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterRegisterService implements VoterRegisterUseCase {

    private final VoterOutPort voterOutPort;
    private final ElectionOutPort electionOutPort;
    @Override
    public boolean registerVoter(VoterRegisterCommand command) {
        Election election = electionOutPort.findById(command.getElectionId());

        if (!election.getStatus().equals(ElectionStatus.PENDING)){
            return false;
        }
        Voter voter = Voter.withoutId(command.getName(), command.getEmail(), election);
        voterOutPort.registerVoter(voter);
        return false;
    }
}
