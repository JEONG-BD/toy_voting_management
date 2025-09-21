package com.example.adapter.candidate.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateJPAEntity, Long>, CandidateCustomRepository {
}
