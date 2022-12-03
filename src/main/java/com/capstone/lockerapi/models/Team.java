package com.capstone.lockerapi.models;

import jakarta.persistence.*;
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
    private String teamWins;

    @Column(name = "team_ties", nullable = false)
    private String teamTies;

    @Column(name = "team_losses", nullable = false)
    private String teamLosses;

    @Column(name = "team_win_percentage", nullable = false)
    private String teamWinPercentage;

    @Column(name = "team_standing", nullable = false)
    private String teamStanding;

    @Column(name = "team_location", nullable = false)
    private String teamLocation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<ForumPost> teamPosts;

    // CONSTRUCTORS
    // First one with id.
    // Second one without id.
    public Team(long id, String teamName, String teamWins, String teamTies, String teamLosses, String teamWinPercentage, String teamStanding, String teamLocation, List<ForumPost> teamPosts) {
        this.id = id;
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamTies = teamTies;
        this.teamLosses = teamLosses;
        this.teamWinPercentage = teamWinPercentage;
        this.teamStanding = teamStanding;
        this.teamLocation = teamLocation;
        this.teamPosts = teamPosts;
    }

    public Team(String teamName, String teamWins, String teamTies, String teamLosses, String teamWinPercentage, String teamStanding, String teamLocation, List<ForumPost> teamPosts) {
        this.teamName = teamName;
        this.teamWins = teamWins;
        this.teamTies = teamTies;
        this.teamLosses = teamLosses;
        this.teamWinPercentage = teamWinPercentage;
        this.teamStanding = teamStanding;
        this.teamLocation = teamLocation;
        this.teamPosts = teamPosts;
    }

    public Team() {}

    // GETTERS & SETTERS
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

    public String getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(String teamWins) {
        this.teamWins = teamWins;
    }

    public String getTeamTies() {
        return teamTies;
    }

    public void setTeamTies(String teamTies) {
        this.teamTies = teamTies;
    }

    public String getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(String teamLosses) {
        this.teamLosses = teamLosses;
    }

    public String getTeamWinPercentage() {
        return teamWinPercentage;
    }

    public void setTeamWinPercentage(String teamWinPercentage) {
        this.teamWinPercentage = teamWinPercentage;
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

    public List<ForumPost> getTeamPosts() {
        return teamPosts;
    }

    public void setTeamPosts(List<ForumPost> teamPosts) {
        this.teamPosts = teamPosts;
    }
}
