package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;


import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.FixedDeposit;

public interface FixedDepositService {
	
	List<FixedDeposit> FixedByAccountNumber(String accountNumber);
	void createNewFixedDeposit(FixedDeposit fixedDeposit) ;

}
