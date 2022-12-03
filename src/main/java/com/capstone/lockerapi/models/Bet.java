package com.capstone.lockerapi.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bet_amount", nullable = false)
    private double betAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "scheduled_at", nullable = false)
    private LocalDate scheduledAt;

    @OneToOne
    private User creator;

    @OneToOne
    private User participant;

    @OneToOne
    private Team winningTeam;

}
