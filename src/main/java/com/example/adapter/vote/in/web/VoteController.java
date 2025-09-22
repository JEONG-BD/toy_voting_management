package com.example.adapter.vote.in.web;

import com.example.adapter.vote.dto.CastVoteRequestDto;
import com.example.adapter.vote.dto.CastVoteResponseDto;
import com.example.application.vote.port.in.VoteCastCommand;
import com.example.application.vote.port.in.VoteCastUseCase;
import com.example.domain.vote.Vote;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CastVoteResponseDto> castVote(@RequestBody CastVoteRequestDto dto){
        VoteCastCommand command = new VoteCastCommand(dto.voterId(), dto.candidateId());
        Vote vote = castUseCase.castVote(command);
        CastVoteResponseDto result = CastVoteResponseDto.from(vote);
        return ResponseEntity.ok(result);
    }
}
