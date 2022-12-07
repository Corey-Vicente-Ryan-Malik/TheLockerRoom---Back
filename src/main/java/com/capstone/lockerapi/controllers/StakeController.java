package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.models.Stake;
import com.capstone.lockerapi.services.StakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/stakes")
public class StakeController {

    @Autowired
    private StakeService stakeService;

    @GetMapping
    public List<Stake> viewAllStakes() {
        return stakeService.viewAllStakes();
    }

    @GetMapping("/{id}")
    public Optional<Stake> viewStake(@PathVariable long id) {
        return stakeService.findStakeById(id);
    }

    @PostMapping("/create")
    public Stake createStake(@RequestBody Stake stake) {
        return stakeService.saveStake(stake);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStake(@PathVariable long id) {
        stakeService.deleteStakeById(id);
    }
}
