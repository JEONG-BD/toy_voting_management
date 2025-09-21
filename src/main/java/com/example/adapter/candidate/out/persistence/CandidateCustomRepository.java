package com.example.adapter.candidate.out.persistence;

import com.example.application.candidate.port.in.CandidateFindCommand;

import java.util.List;

public interface CandidateCustomRepository {

    List<CandidateJPAEntity> findByFilter(CandidateFindCommand command);
}
