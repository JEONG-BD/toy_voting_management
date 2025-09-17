package com.example.vote.voter.adapter.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.voter.adapter.dto.ElectionCreateRequestDto;
import com.example.vote.voter.application.port.in.ElectionRegisterCommand;
import com.example.vote.voter.application.port.in.ElectionRegisterUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
@Tag(name="Election", description="Api for election")
public class ElectionController {

    @Autowired
    private ElectionRegisterUseCase useCase;

    @PostMapping
    public String registerElection(@RequestBody ElectionCreateRequestDto dto) {
        ElectionRegisterCommand command = new ElectionRegisterCommand(dto.name(), dto.description(), dto.startTime(), dto.endTile());
        useCase.registerElection(command);
        return "Success";
    }

    @GetMapping("path")
    public String findElection(@PathVariable Long electionId) {
        useCase.registerElection(electionId);
        return "Success";
    }
    
}
