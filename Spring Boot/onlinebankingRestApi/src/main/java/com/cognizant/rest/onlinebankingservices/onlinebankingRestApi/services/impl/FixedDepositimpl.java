package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.FixedDepositDao;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.FixedDeposit;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.FixedDepositService;


@Service
public class FixedDepositimpl implements FixedDepositService {
	

	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@Autowired
	private FixedDepositDao fixedDepositDao;

	@Override
	public List<FixedDeposit> FixedByAccountNumber(String accountNumber) {
	
		AccountDetails aDetails = accountDetailsService.findByAccountNumber(accountNumber);
		List<FixedDeposit> fixeddepositList = aDetails.getFixedDepositList();
		return fixeddepositList;
		

	}

	@Override
	public void createNewFixedDeposit(FixedDeposit fixedDeposit) {
		fixedDepositDao.save(fixedDeposit);
		
	}

}
