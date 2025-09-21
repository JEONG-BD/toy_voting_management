package com.example.application.voter.service;

import com.example.application.voter.port.in.VoterUpdateCommand;
import com.example.application.voter.port.in.VoterUpdateUseCase;
import org.springframework.stereotype.Service;

@Service
public class VoterUpdateService implements VoterUpdateUseCase {

    @Override
    public boolean updateVoter(VoterUpdateCommand command) {
        return false;
    }
}
