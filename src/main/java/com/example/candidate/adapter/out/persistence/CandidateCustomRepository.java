package com.example.candidate.adapter.out.persistence;

import com.example.candidate.application.port.in.CandidateFindCommand;

import java.util.List;

public interface CandidateCustomRepository {

    List<CandidateJPAEntity> findByFilter(CandidateFindCommand command);
}
