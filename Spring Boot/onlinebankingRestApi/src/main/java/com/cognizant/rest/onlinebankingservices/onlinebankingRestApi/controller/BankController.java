package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.AccountDao;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;


@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
	
	@Autowired
	private AccountDetailsService accountDetails;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "Praballlllllll";
	}

	//get the accounts
	
	@GetMapping("/accountdetails")
	public List<AccountDetails> getAccounts()
	{
		return accountDetails.getAccounts();
		
	}
	
	@GetMapping("/account/{accountNumber}")
	public AccountDetails getAccountDetails(@PathVariable("accountNumber") String accountNumber) {
	   return accountDetails.findByAccountNumber(accountNumber);
		
		
	}
	
	@GetMapping("/login/{username}/{password}")
	public boolean performLogin(@PathVariable("username") String username, @PathVariable("password") String password)
	{
		if(accountDetails.performLogin(username, password))
		{
			return true;
		}
		return false;
	}
	
	@PostMapping(path = "/newAccount", consumes = "application/json")
	public AccountDetails createNewAccount(@RequestBody AccountDetails accountDetails1) {

		return accountDetails.addNewAccount(accountDetails1);
		
		
	}
	
	@PutMapping("/updateAccount")
    public AccountDetails updateAccount(@RequestBody AccountDetails accountDetails1) {
		
		return accountDetails.updateAccount(accountDetails1);
	}
}
