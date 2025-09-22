package com.example.adapter.election.out.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.adapter.vote.out.persistence.VoteJPAEntity;
import com.example.adapter.voter.out.persistence.entity.VoterJPAEntity;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private ElectionStatusJPAEntity status;
    
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoterJPAEntity> voters = new ArrayList<>();

    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteJPAEntity> votes = new ArrayList<>();

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

    public ElectionStatusJPAEntity getStatus() {
        return this.status;
    }
    
    public List<VoterJPAEntity> getVoters(){
        return this.voters;
    }

    public void update(String title, String description, LocalDateTime start, LocalDateTime end, ElectionStatusJPAEntity status) {
        this.title = title;
        this.description = description;
        this.startDate = start;
        this.endDate = end;
        this.status = status;
    }
    
}
