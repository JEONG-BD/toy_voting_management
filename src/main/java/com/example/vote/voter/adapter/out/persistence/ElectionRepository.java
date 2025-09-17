package com.example.vote.voter.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<ElectionJPAEntity, Long>{


}
