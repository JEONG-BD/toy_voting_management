package com.example.vote.voter.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Election {
    private final Long id;
    
    @Getter 
    private final String title;
    
    @Getter 
    private final String description;
    
    @Getter 
    private final LocalDateTime startDate;
    
    @Getter 
    private final LocalDateTime endDate;
    
    @Getter 
    private final ElectionStatus status;
    //private List<Candidate> candidates; 

    public static Election withoutId(String title, String description, LocalDateTime startDate, LocalDateTime enDate, ElectionStatus status ){
        return new Election(null, title, description, startDate, enDate, status);
    }

        public static Election withId(Long id, String title, String description, LocalDateTime startDate, LocalDateTime enDate, ElectionStatus status ){
        return new Election(id, title, description, startDate, enDate, status);
    }

}
