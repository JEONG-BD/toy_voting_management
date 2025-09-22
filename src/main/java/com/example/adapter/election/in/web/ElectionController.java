package com.example.adapter.election.in.web;

import com.example.adapter.election.dto.ElectionUpdateRequestDto;
import com.example.application.election.port.in.*;
import com.example.adapter.election.dto.ElectionResponseDto;
import com.example.domain.election.Election;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.adapter.election.dto.ElectionRequestDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
@Tag(name="Election", description="Api for election")
public class ElectionController {

    private final ElectionRegisterUseCase registerUseCase;
    private final ElectionFindByIdUseCase findUseCase;
    private final ElectionFindAllUseCase findAllUseCase;
    private final ElectionUpdateUseCase updateUseCase;
    private final ElectionDeleteUseCase deleteUseCase;


    @PostMapping
    public String registerElection(@RequestBody ElectionRequestDto dto) {
        ElectionRegisterCommand command = new ElectionRegisterCommand(dto.title(),
                dto.description(),
                dto.startDate(),
                dto.endDate());
        registerUseCase.registerElection(command);
        return "Success";
    }

    //@GetMapping("/{electionId}")
    //public ResponseEntity<Election> findElection(@PathVariable("electionId") Long electionId) {
    //    Election election = findUseCase.findById(electionId);
    //    return ResponseEntity.ok().body(election);
    //}

    @GetMapping
    public ResponseEntity<List<Election>> findElection(@RequestParam(name = "id", required = false) Long electionId,
                                                 @RequestParam(name = "title",required = false) String name,
                                                 @RequestParam(name = "description",required = false) String description,
                                                 @RequestParam(name = "startDate",required = false) LocalDateTime startDate,
                                                 @RequestParam(name = "endDate",required = false) LocalDateTime endDate,
                                                 @RequestParam(name = "status",required = false) String status

                                                 ) {

        ElectionFindFilterCommand command = new ElectionFindFilterCommand(electionId, name, description, startDate, endDate, status);
        List<Election> result = findAllUseCase.findByFilter(command);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{electionId}")
    public ResponseEntity<Election> deleteElection(@PathVariable("electionId") Long electionId) {
        deleteUseCase.delete(electionId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<ElectionResponseDto> updateElection(@RequestBody ElectionUpdateRequestDto dto) {

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
