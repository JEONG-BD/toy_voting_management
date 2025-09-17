package com.example.vote.voter.adapter.in.web;

import com.example.vote.election.adapter.dto.VoterCreateRequestDto;
import com.example.vote.voter.application.port.in.RegisterVoterCommand;
import com.example.vote.voter.application.port.in.RegisterVoterUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voter")
@Tag(name="Voter", description = "Api for Voter")
public class VoterController {

    private final RegisterVoterUseCase registerUseCase;

    @PostMapping
    @Operation(summary = "Register a voter")
    public void registerVoter(@RequestBody VoterCreateRequestDto dto){
        RegisterVoterCommand command = new RegisterVoterCommand();
        registerUseCase.registerVoter( command);
    }

    @GetMapping
    @Operation(summary = "Register a voter")
    public Void findVoter(){
        RegisterVoterCommand command = new RegisterVoterCommand();
        registerUseCase.registerVoter( command);
        return null;
    }
}
