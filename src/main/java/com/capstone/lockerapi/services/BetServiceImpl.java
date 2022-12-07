package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Bet;
import com.capstone.lockerapi.repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public Bet saveBet(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    public List<Bet> viewAllBets() {
        return betRepository.findAll();
    }

    @Override
    public Optional<Bet> findBetById(long id) {
        return betRepository.findById(id);
    }

    @Override
    public void deleteBetById(long id) {
        betRepository.deleteById(id);
    }

}
