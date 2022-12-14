package com.capstone.lockerapi.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "team_wins", nullable = false)
    private int teamWins;

    @Column(name = "team_ties", nullable = false)
    private int teamTies;

    @Column(name = "team_losses", nullable = false)
    private int teamLosses;

    @Column(name = "team_standing", nullable = false)
    private String teamStanding;

    @Column(name = "team_location", nullable = false)
    private String teamLocation;

    @Column(name = "division_wins")
    private int divisionWins;

    @Column(name = "division_ties")
    private int divisionTies;

    @Column(name = "division_losses")
    private int division_losses;

    @Column(name = "api_id")
    private int apiId;


    public Team(long id, String teamName, int teamWins, int teamTies, int teamLosses, String teamStanding, String teamLocation, int divisionWins, int divisionTies, int division_losses) {
        this.id = id;
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamTies = teamTies;
        this.teamLosses = teamLosses;
        this.teamStanding = teamStanding;
        this.teamLocation = teamLocation;
        this.divisionWins = divisionWins;
        this.divisionTies = divisionTies;
        this.division_losses = division_losses;
    }

    public Team(String teamName, int teamWins, int teamTies, int teamLosses, String teamStanding, String teamLocation, int divisionWins, int divisionTies, int division_losses) {
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamTies = teamTies;
        this.teamLosses = teamLosses;
        this.teamStanding = teamStanding;
        this.teamLocation = teamLocation;
        this.divisionWins = divisionWins;
        this.divisionTies = divisionTies;
        this.division_losses = division_losses;
    }

    public Team() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(int teamWins) {
        this.teamWins = teamWins;
    }

    public int getTeamTies() {
        return teamTies;
    }

    public void setTeamTies(int teamTies) {
        this.teamTies = teamTies;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(int teamLosses) {
        this.teamLosses = teamLosses;
    }


    public String getTeamStanding() {
        return teamStanding;
    }

    public void setTeamStanding(String teamStanding) {
        this.teamStanding = teamStanding;
    }

    public String getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(String teamLocation) {
        this.teamLocation = teamLocation;
    }

    public int getDivisionWins() {
        return divisionWins;
    }

    public void setDivisionWins(int divisionWins) {
        this.divisionWins = divisionWins;
    }

    public int getDivisionTies() {
        return divisionTies;
    }

    public void setDivisionTies(int divisionTies) {
        this.divisionTies = divisionTies;
    }

    public int getDivision_losses() {
        return division_losses;
    }

    public void setDivision_losses(int division_losses) {
        this.division_losses = division_losses;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

}
