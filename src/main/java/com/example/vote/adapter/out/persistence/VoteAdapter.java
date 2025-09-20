package com.example.vote.adapter.out.persistence;

import com.example.vote.application.port.out.VoteOutPort;
import com.example.vote.domain.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class VoteAdapter implements VoteOutPort {

    private final VoteMapper voteMapper;
    private final VoteRepository voteRepository;

    @Override
    public Vote castVote(Vote vote) {
        VoteJPAEntity voteJPAEntity = voteMapper.mapToEntity(vote);
        voteRepository.save(voteJPAEntity);
        return voteMapper.mapToDomain(voteJPAEntity);
    }
}
