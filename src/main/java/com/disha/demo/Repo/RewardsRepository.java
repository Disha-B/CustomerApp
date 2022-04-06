package com.disha.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disha.demo.model.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer>{

	
}
