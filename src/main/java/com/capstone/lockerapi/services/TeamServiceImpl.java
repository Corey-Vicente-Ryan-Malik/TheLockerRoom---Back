package com.capstone.lockerapi.services;


import com.capstone.lockerapi.models.Team;
import com.capstone.lockerapi.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<Team> viewAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> getTeam(long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeamById(long id) {
        teamRepository.deleteById(id);
    }
}
