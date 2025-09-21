package com.example.adapter.election.in.web;

import com.example.application.election.port.in.*;
import com.example.adapter.election.dto.ElectionResponseDto;
import com.example.domain.Election;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.adapter.election.dto.ElectionRequestDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
@Tag(name="Election", description="Api for election")
public class ElectionController {

    @Autowired
    private ElectionRegisterUseCase registerUseCase;
    @Autowired
    private ElectionFindByIdUseCase findUseCase;
    @Autowired
    private ElectionUpdateUseCase updateUseCase;
    @Autowired
    private ElectionDeleteUseCase deleteUseCase;


    @PostMapping
    public String registerElection(@RequestBody ElectionRequestDto dto) {
        ElectionRegisterCommand command = new ElectionRegisterCommand(dto.title(),
                dto.description(),
                dto.startDate(),
                dto.endDate());
        registerUseCase.registerElection(command);
        return "Success";
    }

    @GetMapping("/{electionId}")
    public ResponseEntity<Election> findElection(@PathVariable("electionId") Long electionId) {
        Election election = findUseCase.findById(electionId);
        return ResponseEntity.ok().body(election);
    }

    @DeleteMapping("/{electionId}")
    public ResponseEntity<Election> deleteElection(@PathVariable("electionId") Long electionId) {
        deleteUseCase.delete(electionId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<ElectionResponseDto> updateElection(@RequestBody ElectionRequestDto dto) {

        ElectionUpdateCommand command = new ElectionUpdateCommand(dto.id(),
                dto.title(),
                dto.description(),
                dto.startDate(),
                dto.endDate());

        Election election = updateUseCase.updateElection(command);
        ElectionResponseDto result = ElectionResponseDto.from(election);
        return ResponseEntity.ok().body(result);
    }

    
}
