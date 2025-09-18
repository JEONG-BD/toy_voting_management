package com.example.vote.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "vote")
public class VoteJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
