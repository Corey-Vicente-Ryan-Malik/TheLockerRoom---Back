package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.models.Stake;
import com.capstone.lockerapi.services.StakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:3000")
public class StakeController {

    @Autowired
    private StakeService stakeService;

    // Mapping to CREATE new stake entity.
    @PostMapping("/stakes/create")
    public ResponseEntity<Stake> createStake(@RequestBody Stake stake) {
        return ResponseEntity.ok().body(stakeService.saveStake(stake));
    }

    // Mapping to READ/VIEW all stakes in DB.
    @GetMapping("/stakes")
    public ResponseEntity<List<Stake>> viewAllStakes() {
        return ResponseEntity.ok().body(stakeService.viewAllStakes());
    }

    // Mapping to READ/VIEW single stake.
    @GetMapping("/stakes/{id}")
    public ResponseEntity<Optional<Stake>> viewStake(@PathVariable long id) {
        return ResponseEntity.ok().body(stakeService.findStakeById(id));
    }

    // Mapping to DELETE single stake.
    @DeleteMapping("/stakes/{id}/delete")
    public ResponseEntity<?> deleteStake(@PathVariable long id) {
        stakeService.deleteStakeById(id);
        return ResponseEntity.noContent().build();
    }
}
