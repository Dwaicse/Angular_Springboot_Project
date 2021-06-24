package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Cards;




public interface AccountDetailsService {
	
	public List<AccountDetails> getAccounts();
    public AccountDetails findByAccountNumber(String accountNumber);
	public AccountDetails addNewAccount(AccountDetails accountDetails);
	public AccountDetails updateAccount(AccountDetails accountDetails);
	public boolean performLogin(String username, String password);
	public AccountDetails findByEmail(String email);
	
	public boolean checkAccountNumberExist(String accountNumber);
	public boolean checkUserExists(String username, String email);
	public boolean checkUsernameExists(String username);
	public boolean checkEmailExists(String email);
	public List<Cards> findCardsByAccountNumber(String accountNumber);
	AccountDetails findByUserName(String userName);
	
	String findCardNumber(String userName);
	

}
