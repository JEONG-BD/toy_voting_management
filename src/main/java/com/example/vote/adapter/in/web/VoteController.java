package com.example.vote.adapter.in.web;

import com.example.vote.adapter.dto.CastVoteRequestDTO;
import com.example.vote.application.port.in.VoteCastCommand;
import com.example.vote.application.port.in.VoteCastUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
@Tag(name="vote", description = "Api for vote")
public class VoteController {

    private final VoteCastUseCase castUseCase;

    @PostMapping
    @Operation(description = "cast a vote")
    public void castVote(@RequestBody CastVoteRequestDTO dto){
        VoteCastCommand command = new VoteCastCommand(dto.voterId(), dto.electionId(), dto.candidateId());
        castUseCase.castVote(command);
    }
}
