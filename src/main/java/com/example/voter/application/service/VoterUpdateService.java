package com.example.voter.application.service;

import com.example.voter.application.port.in.VoterUpdateCommand;
import com.example.voter.application.port.in.VoterUpdateUseCase;
import org.springframework.stereotype.Service;

@Service
public class VoterUpdateService implements VoterUpdateUseCase {

    @Override
    public boolean updateVoter(VoterUpdateCommand command) {
        return false;
    }
}
