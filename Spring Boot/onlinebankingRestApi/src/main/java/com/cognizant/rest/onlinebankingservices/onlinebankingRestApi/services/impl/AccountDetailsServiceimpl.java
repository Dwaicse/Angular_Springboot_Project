package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.AccountDao;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;

@Service
public class AccountDetailsServiceimpl implements AccountDetailsService {
	
	@Autowired
	private AccountDao accountDao;
	
	
	
	List<AccountDetails> accountDetailsList;
	
	
	

	@Override
	public List<AccountDetails> getAccounts() {
		 
		return (List<AccountDetails>) accountDao.findAll();
	}







	@Override
	public AccountDetails addNewAccount(AccountDetails accountDetails) {
	      accountDao.save(accountDetails);
	      return accountDetails;
	}



	@Override
	public AccountDetails updateAccount(AccountDetails accountDetails) {
		accountDao.save(accountDetails);
		return accountDetails;
	}
	
	
	







	@Override
	public AccountDetails findByAccountNumber(String accountNumber) {
		return  accountDao.findById(accountNumber).orElse(null);
		
	}

	






	@Override
	public boolean performLogin(String username, String password) {
		
		AccountDetails accountDetails = accountDao.findByUsername(username);
		if(accountDetails.getPassword().equals(password))
		{
			return true;
		}
		
	return false;
		
}







	@Override
	public AccountDetails findByEmail(String email) {
		// TODO Auto-generated method stub
		return accountDao.findByEmail(email);
	}







	@Override
	public boolean checkUserExists(String username, String email) {
	     AccountDetails accountDetails =accountDao.findByEmail(email);
	    		 
	   if(accountDetails.getUsername()==username){
	    	 return true;
	     }
	 
		return false;
	}







	@Override
	public boolean checkUsernameExists(String username) {
		AccountDetails accountDetails = accountDao.findByUsername(username);
		if(accountDetails != null)
		{
			return true;
		}
		return false;
	}


	
	





	@Override
	public boolean checkEmailExists(String email) {
		   AccountDetails accountDetails =accountDao.findByEmail(email);
  		 
		   if(accountDetails.getUsername()==email){
		    	 return true;
		     }
		return false;
	}







	@Override
	public boolean checkAccountNumberExist(String accountNumber) {
		
		AccountDetails accountDetails = accountDao.findById(accountNumber).orElse(null);
		if(accountDetails != null)
		{
			return true;
		}
		return false;

	}

















}
