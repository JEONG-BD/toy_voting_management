package com.example.voter.adapter.in.web;

import com.example.voter.adapter.dto.VoterRequestDto;

import com.example.voter.adapter.dto.VoterResponseDto;
import com.example.voter.application.port.in.VoterFindByIdUseCase;
import com.example.voter.application.port.in.VoterRegisterCommand;
import com.example.voter.application.port.in.VoterRegisterUseCase;

import com.example.voter.application.port.in.VoterUpdateUseCase;
import com.example.voter.domain.Voter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voter")
@Tag(name="Voter", description = "Api for Voter")
public class VoterController {

    private final VoterRegisterUseCase registerUseCase;
    private final VoterUpdateUseCase updateUseCase;
    private final VoterFindByIdUseCase findUseCase;
    @PostMapping
    @Operation(summary = "Register a voter")
    public void registerVoter(@RequestBody VoterRequestDto dto){
        VoterRegisterCommand command = new VoterRegisterCommand(dto.name(), dto.email(), dto.electionId());
        registerUseCase.registerVoter(command);
    }

    @GetMapping("/{voterId}")
    @Operation(summary = "Find a Voter")
    public ResponseEntity<VoterResponseDto> findVoter(@PathVariable("voterId") Long voterId){
        Voter voter = findUseCase.findByIdVoter(voterId);
        VoterResponseDto result = VoterResponseDto.from(voter);
        return ResponseEntity.ok().body(result);
    }
}
