package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;

public interface AdminService {
	
	String createNewUser(AccountDetails accountDetails);
	String blockAuser(String accountNumber);
	void showPendingRequests();
	String createNewFixedDeposit();
	String approvePendingLoans();
	

}
