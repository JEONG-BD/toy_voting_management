package com.example.candidate.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateJPAEntity, Long> {
}
