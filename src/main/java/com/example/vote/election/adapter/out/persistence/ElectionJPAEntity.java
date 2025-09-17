package com.example.vote.election.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.vote.voter.adapter.out.persistence.VoterJPAEntity;

import com.example.vote.voter.domain.ElectionStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="election")
@Builder
public class ElectionJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private ElectionStatus status;
    
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoterJPAEntity> voters = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public ElectionStatus getStatus() {
        return this.status;
    }
    
    public List<VoterJPAEntity> getVoters(){
        return this.voters;
    }

    public void update(String title, String description, LocalDateTime start, LocalDateTime end, ElectionStatus status) {
        this.title = title;
        this.description = description;
        this.startDate = start;
        this.endDate = end;
        this.status = status;
    }
    
}
