package com.capstone.lockerapi.controllers;

import com.capstone.lockerapi.models.Bet;
import com.capstone.lockerapi.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private BetService betService;

    @GetMapping
    public List<Bet> viewAllBets() {
        return betService.viewAllBets();
    }

    @GetMapping("/{id}")
    public Optional<Bet> viewBet(@PathVariable long id) {
        return betService.findBetById(id);
    }

    @PostMapping("/create")
    public Bet createBet(@RequestBody Bet bet) {
        return betService.saveBet(bet);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBet(@PathVariable long id) {
        betService.deleteBetById(id);
    }
}
