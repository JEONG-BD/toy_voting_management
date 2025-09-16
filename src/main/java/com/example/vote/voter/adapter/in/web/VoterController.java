package com.example.vote.voter.adapter.in.web;

import com.example.vote.voter.application.port.in.RegisterVoterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voter")
public class VoterController {

    private final RegisterVoterUseCase registerUseCase;

    @PostMapping
    public Void registerVoter(){


        registerUseCase.registerVoter()
    }
}
