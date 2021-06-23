package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;


import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Loan;

public interface LoanService {
	
	List<Loan> LoansByAccountNumber(String accountNumber);

}
