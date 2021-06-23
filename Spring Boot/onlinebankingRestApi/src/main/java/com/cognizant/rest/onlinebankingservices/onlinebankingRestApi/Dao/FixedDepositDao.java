package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.FixedDeposit;

public interface FixedDepositDao extends JpaRepository<FixedDeposit, Long> {
	


}
