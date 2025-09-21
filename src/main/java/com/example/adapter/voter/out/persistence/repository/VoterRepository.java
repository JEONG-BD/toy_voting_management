package com.example.adapter.voter.out.persistence.repository;

import com.example.adapter.voter.out.persistence.entity.VoterJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterJPAEntity, Long> {
}
