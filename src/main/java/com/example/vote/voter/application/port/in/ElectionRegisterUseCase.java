package com.example.vote.voter.application.port.in;

public interface ElectionRegisterUseCase {

    boolean registerElection(ElectionRegisterCommand command);
}
