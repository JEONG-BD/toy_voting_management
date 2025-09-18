package com.example.voter.application.service;

import com.example.election.application.port.out.ElectionOutPort;
import com.example.election.domain.Election;
import com.example.election.domain.ElectionStatus;
import com.example.voter.application.port.in.VoterRegisterCommand;
import com.example.voter.application.port.in.VoterRegisterUseCase;
import com.example.voter.application.port.out.VoterOutPort;
import com.example.voter.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterRegisterService implements VoterRegisterUseCase {

    private final VoterOutPort voterOutPort;
    private final ElectionOutPort electionOutPort;
    @Override
    public boolean registerVoter(VoterRegisterCommand command) {
        System.out.println(command.getElectionId());
        System.out.println(command.getElectionId());
        System.out.println(command.getElectionId());
        System.out.println(command.getElectionId());
        Election election = electionOutPort.findById(command.getElectionId());

        if (!election.getStatus().equals(ElectionStatus.PENDING)){
            return false;
        }
        Voter voter = Voter.withoutId(command.getName(), command.getEmail(), election);
        voterOutPort.registerVoter(voter);
        return false;
    }
}
