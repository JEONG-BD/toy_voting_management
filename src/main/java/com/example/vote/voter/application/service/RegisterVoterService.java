package com.example.vote.voter.application.service;

import com.example.vote.voter.application.port.in.RegisterVoterCommand;
import com.example.vote.voter.application.port.in.RegisterVoterUseCase;

public class RegisterVoterService implements RegisterVoterUseCase {

    @Override
    public boolean registerVoter(RegisterVoterCommand command) {
        return false;
    }
}
