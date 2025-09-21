package com.example.voter.adapter.out.persistence.repository;

import com.example.voter.adapter.out.persistence.entity.VoterJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterJPAEntity, Long> {
}
