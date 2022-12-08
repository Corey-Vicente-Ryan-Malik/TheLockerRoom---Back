package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.TeamNotFoundException;
import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.Team;
import com.capstone.lockerapi.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.viewAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable long id) {
        return teamService.getTeam(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @PutMapping("/edit/{id}")
    public Team updateTeam(@RequestBody Team teamToEdit, @PathVariable long id) {
        return teamService.getTeam(id)
                .map(team -> {
                    team.setTeamName(teamToEdit.getTeamName());
                    team.setTeamWins(teamToEdit.getTeamWins());
                    team.setTeamTies(teamToEdit.getTeamTies());
                    team.setTeamLosses(teamToEdit.getTeamLosses());
                    team.setTeamWinPercentage(teamToEdit.getTeamWinPercentage());
                    team.setTeamStanding(teamToEdit.getTeamStanding());
                    team.setTeamLocation(teamToEdit.getTeamLocation());
                    return teamService.saveTeam(team);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/save")
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable long id) {
        teamService.deleteTeamById(id);
        return "Team has been deleted.";
    }

}
