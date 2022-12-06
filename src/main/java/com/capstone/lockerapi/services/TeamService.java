package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    public List<Team> viewAllTeams();
    public Optional<Team> getTeam(long id);
    public Team saveTeam(Team team);
    public void deleteTeamById(long id);
}
