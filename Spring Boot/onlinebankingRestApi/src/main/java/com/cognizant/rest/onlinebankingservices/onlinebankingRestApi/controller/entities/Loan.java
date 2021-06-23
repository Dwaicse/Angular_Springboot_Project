package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	private String amount;
	private String term;
	private String emiamount;
	private String loanType;
	private Date dateofissue;
	
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private AccountDetails accountDetails;
	

	@Override
	public String toString() {
		return "Loan [id=" + id + ", amount=" + amount + ", term=" + term + ", emiamount=" + emiamount + ", loanType="
				+ loanType + ", dateofissue=" + dateofissue + ", accountDetails=" + accountDetails + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public String getEmiamount() {
		return emiamount;
	}


	public void setEmiamount(String emiamount) {
		this.emiamount = emiamount;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public Date getDateofissue() {
		return dateofissue;
	}


	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
	}


	public AccountDetails getAccountDetails() {
		return accountDetails;
	}


	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}



	

}
