package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Transactions;

public interface TransactionService {
	
	List<Transactions> findTransactions(String accountNumber);
	String betweenAccountsTransfer(String transferFrom, String transferTo, String amount);
	
	void saveWithdrawTransaction(Transactions transactions);
	void saveDepositTransaction(Transactions transactions);
	
	

}
