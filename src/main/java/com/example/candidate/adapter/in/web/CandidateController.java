package com.example.candidate.adapter.in.web;

import com.example.candidate.adapter.dto.CandidateRequestDTO;
import com.example.candidate.application.port.in.CandateRegisterCommand;
import com.example.candidate.application.port.in.CandidateRegisterUseCase;
import com.example.candidate.domain.Candidate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candidate")
@Tag(name="Candidate", description = "Api for Candidate")
public class CandidateController {

    private final CandidateRegisterUseCase registerUseCase;

    @PostMapping
    @Operation(description = "Register a candidate")
    public ResponseEntity<Candidate> registerCandidate(@RequestBody CandidateRequestDTO dto){
        CandateRegisterCommand command = new CandateRegisterCommand(dto.name(), dto.age(), dto.party(), dto.electionId());
        Candidate candidate = registerUseCase.registerCandidate(command);
        return ResponseEntity.ok(candidate);
    }
}
