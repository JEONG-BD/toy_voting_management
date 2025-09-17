package com.example.vote.voter.adapter.out.persistence;

import com.example.vote.voter.application.port.out.RegisterVoterPort;
import com.example.vote.voter.domain.Voter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VoterAdapter implements RegisterVoterPort {

    private final VoterRepository voterRepository;
    private final VoterMapper voterMapper;

    @Override
    public void registerVoter(Voter voter) {
        //VoterJPAEntity voterJPAEntity = voterMapper.mapToEntity(voter);
        //voterRepository.save(voterJPAEntity);
    }
}
