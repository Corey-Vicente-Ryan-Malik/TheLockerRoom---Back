package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.exceptions.TeamNotFoundException;
import com.capstone.lockerapi.exceptions.UserNotFoundException;
import com.capstone.lockerapi.models.Team;
import com.capstone.lockerapi.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Mapping to CREATE/SAVE new team entity.
    @PostMapping("/teams/save")
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        return ResponseEntity.ok().body(teamService.saveTeam(team));
    }

    // Mapping to READ/VIEW all teams in DB.
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.viewAllTeams());
    }

    // Mapping to READ/VIEW single team.
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable long id) {
        return ResponseEntity.ok().body(teamService.getTeam(id).orElseThrow(() -> new TeamNotFoundException(id)));
    }

    // Mapping to UPDATE/EDIT team.
    @PutMapping("/teams/{id}/edit-team")
    public ResponseEntity<Team> updateTeam(@RequestBody Team teamToEdit, @PathVariable long id) {
        return ResponseEntity.ok().body(teamService.getTeam(id)
                .map(team -> {
                    team.setTeamName(teamToEdit.getTeamName());
                    team.setTeamWins(teamToEdit.getTeamWins());
                    team.setTeamTies(teamToEdit.getTeamTies());
                    team.setTeamLosses(teamToEdit.getTeamLosses());
                    team.setTeamWinPercentage(teamToEdit.getTeamWinPercentage());
                    team.setTeamStanding(teamToEdit.getTeamStanding());
                    team.setTeamLocation(teamToEdit.getTeamLocation());
                    return teamService.saveTeam(team);
                }).orElseThrow(() -> new UserNotFoundException(id)));
    }

    // Mapping to DELETE team entity.
    @DeleteMapping("/teams/{id}/delete")
    public ResponseEntity<?> deleteTeam(@PathVariable long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.noContent().build();
    }

}
