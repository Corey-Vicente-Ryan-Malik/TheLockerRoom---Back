package com.capstone.lockerapi.repositories;

import com.capstone.lockerapi.models.Stake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeRepository extends JpaRepository<Stake, Long> {
}
