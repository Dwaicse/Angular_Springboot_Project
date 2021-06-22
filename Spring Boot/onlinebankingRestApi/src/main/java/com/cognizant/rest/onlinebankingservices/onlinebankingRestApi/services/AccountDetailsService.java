package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;



public interface AccountDetailsService {
	
	public List<AccountDetails> getAccounts();
    public AccountDetails findByAccountNumber(String accountNumber);
	public AccountDetails addNewAccount(AccountDetails accountDetails);
	public AccountDetails updateAccount(AccountDetails accountDetails);
	public boolean performLogin(String username, String password);
	public AccountDetails findByEmail(String email);
	public boolean checkUserExists(String username, String email);
	public boolean checkUsernameExists(String username);
	public boolean checkEmailExists(String email);

}
