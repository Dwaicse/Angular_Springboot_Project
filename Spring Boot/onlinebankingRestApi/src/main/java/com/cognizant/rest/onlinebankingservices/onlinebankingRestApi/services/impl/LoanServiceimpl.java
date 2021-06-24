package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.CardsDao;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.LoanDao;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Loan;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.LoanService;

@Service
public class LoanServiceimpl implements LoanService {

	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
    @Autowired
    private CardsDao cardsDao;
	
	@Override
	public List<Loan> LoansByAccountNumber(String accountNumber) {
		AccountDetails aDetails = accountDetailsService.findByAccountNumber(accountNumber);
		List<Loan> loanList = aDetails.getLoanList();
		return loanList;
	}
	
	
	
	
	

}
