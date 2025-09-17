package com.example.vote.election.application.port.in;

public interface ElectionRegisterUseCase {

    boolean registerElection(ElectionRegisterCommand command);
}
