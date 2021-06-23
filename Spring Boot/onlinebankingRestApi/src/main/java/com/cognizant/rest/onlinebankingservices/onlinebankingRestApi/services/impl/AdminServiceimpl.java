package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AdminService;

public class AdminServiceimpl implements AdminService {

	@Autowired
	AccountDetailsService accountDetailsService;
	
	@Override
	public String createNewUser(AccountDetails accountDetails) {
		
		AccountDetails account = accountDetailsService.addNewAccount(accountDetails);
		return "Account Created Suceesfully!\n Account Number is: "+ account.getAccountNumber();
		
	}

	@Override
	public String blockAuser(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showPendingRequests() {
		// TODO Auto-generated method stub

	}

	@Override
	public String createNewFixedDeposit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approvePendingLoans() {
		// TODO Auto-generated method stub
		return null;
	}

}
