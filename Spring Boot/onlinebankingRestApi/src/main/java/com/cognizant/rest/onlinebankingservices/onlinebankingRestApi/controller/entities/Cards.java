package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cardNumber;
	private String cardType;
	private Date issueDate;
	private Date expiryDate;
	
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private AccountDetails accountDetails;
	
	
	
	@Override
	public String toString() {
		return "Cards [id=" + id + ", cardNumber=" + cardNumber + ", cardType=" + cardType + ", issueDate=" + issueDate
				+ ", expiryDate=" + expiryDate + ", accountDetails=" + accountDetails + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public AccountDetails getAccountDetails() {
		return accountDetails;
	}


	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}


	
	
	

}
