package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FixedDeposit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	private String amount;
	private String term;
	private String depositType;
	private Date dateoffixeDate;
	private Date dateofMaturity;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private AccountDetails accountDetails;
	
	@Override
	public String toString() {
		return "FixedDeposit [id=" + id + ", amount=" + amount + ", term=" + term + ", depositType=" + depositType
				+ ", dateoffixeDate=" + dateoffixeDate + ", dateofMaturity=" + dateofMaturity + ", accountDetails="
				+ accountDetails + "]";
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

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public Date getDateoffixeDate() {
		return dateoffixeDate;
	}

	public void setDateoffixeDate(Date dateoffixeDate) {
		this.dateoffixeDate = dateoffixeDate;
	}

	public Date getDateofMaturity() {
		return dateofMaturity;
	}

	public void setDateofMaturity(Date dateofMaturity) {
		this.dateofMaturity = dateofMaturity;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}


	
	
	
	
	
	

}
