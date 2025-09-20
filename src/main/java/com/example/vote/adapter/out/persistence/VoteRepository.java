package com.example.vote.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteJPAEntity, Long> {

}
