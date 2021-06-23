package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;
	private String amount;
	private String typeOftransaction; //debited or credited
    private Date transactionDate;
    private String transactiondetails;
    
    
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private AccountDetails accountDetails;
	
	
	
	@Override
	public String toString() {
		return "Transactions [transactionid=" + transactionid + ", amount=" + amount + ", typeOftransaction="
				+ typeOftransaction + ", transactionDate=" + transactionDate + ", transactiondetails="
				+ transactiondetails + ", accountDetails=" + accountDetails + "]";
	}



	public Long getTransactionid() {
		return transactionid;
	}



	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getTypeOftransaction() {
		return typeOftransaction;
	}



	public void setTypeOftransaction(String typeOftransaction) {
		this.typeOftransaction = typeOftransaction;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getTransactiondetails() {
		return transactiondetails;
	}



	public void setTransactiondetails(String transactiondetails) {
		this.transactiondetails = transactiondetails;
	}



	public AccountDetails getAccountDetails() {
		return accountDetails;
	}



	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}




	

}
