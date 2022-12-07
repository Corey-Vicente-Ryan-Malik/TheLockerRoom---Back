package com.capstone.lockerapi.models;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stakes")
public class Stake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stake_amount", nullable = false)
    private double stakeAmount;

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

    // CONSTRUCTORS
    // First one with id.
    // Second one without id.
    public Stake(long id, double stakeAmount, LocalDate createdAt, LocalDate scheduledAt, User creator, User participant, Team winningTeam) {
        this.id = id;
        this.stakeAmount = stakeAmount;
        this.createdAt = createdAt;
        this.scheduledAt = scheduledAt;
        this.creator = creator;
        this.participant = participant;
        this.winningTeam = winningTeam;
    }

    public Stake(double stakeAmount, LocalDate createdAt, LocalDate scheduledAt, User creator, User participant, Team winningTeam) {
        this.stakeAmount = stakeAmount;
        this.createdAt = createdAt;
        this.scheduledAt = scheduledAt;
        this.creator = creator;
        this.participant = participant;
        this.winningTeam = winningTeam;
    }

    public Stake() {}

    // GETTERS & SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(double stakeAmount) {
        this.stakeAmount = stakeAmount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDate scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getParticipant() {
        return participant;
    }

    public void setParticipant(User participant) {
        this.participant = participant;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }
}
