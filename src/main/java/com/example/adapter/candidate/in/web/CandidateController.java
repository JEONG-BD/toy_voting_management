package com.example.adapter.candidate.in.web;

import com.example.adapter.candidate.dto.CandidateUpdateRequestDto;
import com.example.application.candidate.port.in.*;
import com.example.adapter.candidate.dto.CandidateRequestDto;
import com.example.adapter.candidate.dto.CandidateResponseDto;
import com.example.domain.candidate.Candidate;
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
    public ResponseEntity<Candidate> registerCandidate(@RequestBody CandidateRequestDto dto){
        CandidateRegisterCommand command = new CandidateRegisterCommand(dto.name(), dto.age(), dto.party(), dto.electionId());
        Candidate candidate = registerUseCase.registerCandidate(command);
        return ResponseEntity.ok(candidate);
    }

    @GetMapping
    @Operation(description = "Find a candidate")
    public ResponseEntity<List<CandidateResponseDto>> findByFilterCandidate(@RequestParam(name = "name", required = false) String name,
                                                                            @RequestParam(name = "age" , required = false)  Integer age,
                                                                            @RequestParam(name = "party", required = false) String party,
                                                                            @RequestParam(name ="electionId", required = true) Long electionId){

        CandidateFindCommand command = new CandidateFindCommand(name, age, party, electionId);
        List<Candidate> allCandidate = findAllUseCase.findAllCandidate(command);
        List<CandidateResponseDto> result = allCandidate
                .stream()
                .map(CandidateResponseDto::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    @Operation(description ="Update candidate")
    public ResponseEntity<CandidateResponseDto> updateCandidate(@RequestBody CandidateUpdateRequestDto dto){

        CandidateUpdateCommand command = new CandidateUpdateCommand(dto.id(),
                dto.name(),
                dto.age(),
                dto.party(),
                dto.electionId());
        Candidate candidate = updateUseCase.updateCandidate(command);
        CandidateResponseDto result = CandidateResponseDto.from(candidate);
        return ResponseEntity.ok(result);
    }
}
