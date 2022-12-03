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
}
