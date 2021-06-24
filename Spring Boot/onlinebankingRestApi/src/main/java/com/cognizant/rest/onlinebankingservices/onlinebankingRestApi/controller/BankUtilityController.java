package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Cards;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.FixedDeposit;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Loan;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Transactions;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.CardsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.FixedDepositService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.LoanService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("https://localhost:4200")
public class BankUtilityController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@Autowired
	private FixedDepositService fixedDepositService;
	
	
	@Autowired
	private LoanService LoanService;
	
	@Autowired
	private CardsService cardsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "this is transaction controller!";
	}
	
	@GetMapping("/transactions/{accountNumber}")
	public List<Transactions> getTransactions(@PathVariable("accountNumber") String accountNumber)
	{ 
		
	    return transactionService.findTransactions(accountNumber);
	}
	
	@GetMapping("/{from}/{to}/{amt}")
	public String ownBankTransfer(@PathVariable("from") String from, @PathVariable("to")  String to, @PathVariable("amt") String amount  )
	{
		
		return transactionService.betweenAccountsTransfer(from, to, amount);
		
	}
	
	@GetMapping("/fixedDeposit/{ac}")
	public List<FixedDeposit> getFixedDepositList(@PathVariable("ac") String accountNumber)
	{
		return fixedDepositService.FixedByAccountNumber(accountNumber);
		
	}

	@GetMapping("/cards/{accountNumber}")
	public List<Cards> getcardsList(@PathVariable("accountNumber") String accountNumber)
	{
		return accountDetailsService.findCardsByAccountNumber(accountNumber);
	}
	
	@GetMapping("/api/card/{userName}")
	public String getCardNumberbyuserName(@PathVariable("userName") String userName) {
		return cardsService.findCardNumber(userName);
		
	}
	
	
	
	@GetMapping("/loans/{ac}")
	public List<Loan> getLoanList(@PathVariable("ac") String accountNumber)
	{
		return LoanService.LoansByAccountNumber(accountNumber);
	}
}
