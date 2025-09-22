package com.example.application.election.port.out;

import com.example.application.election.port.in.ElectionFindFilterCommand;
import com.example.domain.election.Election;

import java.util.List;

public interface ElectionOutPort {

    void registerElection(Election election);

    Election findById(Long electionId);

    List<Election> findByFilter(ElectionFindFilterCommand command);

    Election updateElection(Election election);

    void removeElection(Long electionId);
}
