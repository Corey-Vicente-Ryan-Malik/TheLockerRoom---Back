package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Stake;
import com.capstone.lockerapi.repositories.StakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StakeServiceImpl implements StakeService {

    @Autowired
    private StakeRepository stakeRepository;

    @Override
    public Stake saveStake(Stake stake) {
        return stakeRepository.save(stake);
    }

    @Override
    public List<Stake> viewAllStakes() {
        return stakeRepository.findAll();
    }

    @Override
    public Optional<Stake> findStakeById(long id) {
        return stakeRepository.findById(id);
    }

    @Override
    public void deleteStakeById(long id) {
        stakeRepository.deleteById(id);
    }

}
