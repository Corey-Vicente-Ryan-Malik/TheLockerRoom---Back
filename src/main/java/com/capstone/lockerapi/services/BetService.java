package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Bet;
import com.capstone.lockerapi.repositories.BetRepository;

import java.util.List;
import java.util.Optional;

public interface BetService {

    public Bet saveBet(Bet bet);
    public List<Bet> viewAllBets();
    public Optional<Bet> findBetById(long id);
    public void deleteBetById(long id);

}
