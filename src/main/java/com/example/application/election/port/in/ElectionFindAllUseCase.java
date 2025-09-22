package com.example.application.election.port.in;

import com.example.domain.election.Election;

import java.util.List;

public interface ElectionFindAllUseCase {

    List<Election> findByFilter(ElectionFindFilterCommand command);
}
