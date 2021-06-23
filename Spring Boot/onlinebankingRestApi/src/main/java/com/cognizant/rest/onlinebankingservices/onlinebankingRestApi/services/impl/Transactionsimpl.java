package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao.TransactionsDao;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Transactions;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.TransactionService;

@Service
public class Transactionsimpl implements TransactionService {
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	
	@Autowired
	private TransactionsDao transactionsDao;

	@Override
	public List<Transactions> findTransactions(String accountNumber) {
		
		AccountDetails aDetails = accountDetailsService.findByAccountNumber(accountNumber);
		List<Transactions> transactionsList = aDetails.getTransactionList();
		
		return transactionsList;
	}

	@Override
	@Transactional
	public String betweenAccountsTransfer(String transferFrom, String transferTo, String amount)  {
		
		Double amt = Double.parseDouble(amount);
		if(!accountDetailsService.checkAccountNumberExist(transferFrom))
		{
			return "Not Exist!";
		}
		AccountDetails accountDetails = accountDetailsService.findByAccountNumber(transferFrom);
		AccountDetails payeeDetails = accountDetailsService.findByAccountNumber(transferTo);
		Double balance   = Double.parseDouble(accountDetails.getBalance());
        Double payeebalance	 = 	Double.parseDouble(payeeDetails.getBalance());
        
        if(amt>balance)
        {
        	return "Not Sufficient Balance";
        }
        
        balance = balance - amt;
        payeebalance = payeebalance + amt;
        
        accountDetails.setBalance(balance.toString());
        payeeDetails.setBalance(payeebalance.toString());
        
     AccountDetails updatedaAccountDetails =  accountDetailsService.updateAccount(accountDetails);
     AccountDetails updatepayeedetails     = accountDetailsService.updateAccount(payeeDetails);
     
     long millis = System.currentTimeMillis();
     Date date = new Date(millis);
     
     
     
     
     Transactions transactionssender = new Transactions() ;
     transactionssender.setAmount(amt.toString());
     transactionssender.setTransactionDate(date);
     transactionssender.setTypeOftransaction("Debited");
     transactionssender.setTransactiondetails("Debited Successfully to"+updatepayeedetails.getFirstname()+ " "+ updatepayeedetails.getLastname());
     transactionssender.setAccountDetails(updatedaAccountDetails);
     this.saveWithdrawTransaction(transactionssender);
     
     
     Transactions transactionsreceiver = new Transactions() ;
     transactionsreceiver.setAmount(amt.toString());
     transactionsreceiver.setTransactionDate(date);
     transactionsreceiver.setTypeOftransaction("Credited");
     transactionsreceiver.setTransactiondetails("Credited Successfully to"+updatepayeedetails.getFirstname()+ " "+ updatepayeedetails.getLastname());
     transactionssender.setAccountDetails(updatepayeedetails);
     this.saveWithdrawTransaction(transactionssender);
     
     
      return "Transaction Succesful!";  
		

	}
	


	@Override
	public void saveWithdrawTransaction(Transactions transactions) {
		transactionsDao.save(transactions);

	}

	@Override
	public void saveDepositTransaction(Transactions transactions) {
		
		transactionsDao.save(transactions);
	}

}
