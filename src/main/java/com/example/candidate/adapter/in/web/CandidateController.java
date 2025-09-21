package com.example.candidate.adapter.in.web;

import com.example.candidate.adapter.dto.CandidateRequestDTO;
import com.example.candidate.adapter.dto.CandidateResponseDTO;
import com.example.candidate.application.port.in.*;
import com.example.candidate.domain.Candidate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candidate")
@Tag(name="Candidate", description = "Api for Candidate")
public class CandidateController {

    private final CandidateRegisterUseCase registerUseCase;
    private final CandidateUpdateUseCase updateUseCase;
    private final CandidateFindAllUseCase findAllUseCase;

    @PostMapping
    @Operation(description = "Register a candidate")
    public ResponseEntity<Candidate> registerCandidate(@RequestBody CandidateRequestDTO dto){
        CandidateRegisterCommand command = new CandidateRegisterCommand(dto.name(), dto.age(), dto.party(), dto.electionId());
        Candidate candidate = registerUseCase.registerCandidate(command);
        return ResponseEntity.ok(candidate);
    }

    @GetMapping
    @Operation(description = "Find a candidate")
    public ResponseEntity<List<CandidateResponseDTO>> findByFilterCandidate(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "age" , required = false)  Integer age,
                                                      @RequestParam(name = "party", required = false) String party,
                                                      @RequestParam(name ="electionId", required = true) Long electionId){

        CandidateFindCommand command = new CandidateFindCommand(name, age, party, electionId);
        List<Candidate> allCandidate = findAllUseCase.findAllCandidate(command);
        List<CandidateResponseDTO> result = allCandidate
                .stream()
                .map(CandidateResponseDTO::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    @Operation(description ="Update candidate")
    public ResponseEntity<CandidateResponseDTO> updateCandidate(@RequestBody CandidateRequestDTO dto){

        CandidateUpdateCommand command = new CandidateUpdateCommand(dto.id(),
                dto.name(),
                dto.age(),
                dto.party(),
                dto.electionId());
        Candidate candidate = updateUseCase.updateCandidate(command);
        CandidateResponseDTO result = CandidateResponseDTO.from(candidate);
        return ResponseEntity.ok(result);
    }
}
