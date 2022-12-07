package com.capstone.lockerapi.services;

import com.capstone.lockerapi.models.Stake;

import java.util.List;
import java.util.Optional;

public interface StakeService {

    public Stake saveStake(Stake stake);
    public List<Stake> viewAllStakes();
    public Optional<Stake> findStakeById(long id);
    public void deleteStakeById(long id);

}
