package com.example.adapter.election.out.persistence;

import com.example.application.election.port.in.ElectionFindFilterCommand;

import java.util.List;

public interface ElectionCustomRepository {
    List<ElectionJPAEntity> findByFilter(ElectionFindFilterCommand command);
}
