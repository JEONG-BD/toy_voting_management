package com.example.voter.adapter.out.persistence;

import com.example.voter.application.port.out.VoterOutPort;
import com.example.voter.domain.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class VoterAdapter implements VoterOutPort {

    private final VoterRepository voterRepository;
    private final VoterMapper voterMapper;

    @Override
    public Voter findByIdVoter(Long voterId) {
        VoterJPAEntity voterEntity = voterRepository.findById(voterId)
                .orElseThrow(() -> new NoSuchElementException("not existing"));
        return voterMapper.mapToDomain(voterEntity);
    }

    @Override
    public void registerVoter(Voter voter) {
        VoterJPAEntity voterJPAEntity = voterMapper.mapToEntity(voter);
        voterRepository.save(voterJPAEntity);
    }

    @Override
    public Voter updateVoter(Voter voter) {
        return null;
    }
}
