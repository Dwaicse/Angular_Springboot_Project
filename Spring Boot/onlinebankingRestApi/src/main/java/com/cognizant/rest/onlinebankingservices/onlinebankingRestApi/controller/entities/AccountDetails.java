package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AccountDetails {
	
	@Id
	@Column(name = "account_number")
	private String accountNumber;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String address;
	private String username;
	private String password;
	private String  dateOfBirth;

	private int isCard;
	private String balance;
	private String rewards;
	private int onlineActive;
	
	@OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<FixedDeposit> fixedDepositList;
	
	
	@OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Loan> loanList;
	
	

	@OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Cards> cards;
	
	
	@OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transactions> transactionList;
	
	
	
	public List<Transactions> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transactions> transactionList) {
		this.transactionList = transactionList;
	}
	public List<Loan> getLoanList() {
		return loanList;
	}
	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;
	}
	public List<Cards> getCardsList() {
		return cards;
	}
	public void setCardsList(List<Cards> cardsList) {
		this.cards = cardsList;
	}
	public List<FixedDeposit> getFixedDepositList() {
		return fixedDepositList;
	}
	public void setFixedDepositList(List<FixedDeposit> fixedDepositList) {
		this.fixedDepositList = fixedDepositList;
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", username=" + username
				+ ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", isCard=" + isCard + ", balance="
				+ balance + ", rewards=" + rewards + ", onlineActive=" + onlineActive + ", fixedDepositList="
				+ fixedDepositList + ", loanList=" + loanList + ", cards=" + cards + ", transactionList="
				+ transactionList + "]";
	}
	public int getIsCard() {
		return isCard;
	}
	public void setIsCard(int isCard) {
		this.isCard = isCard;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getRewards() {
		return rewards;
	}
	public void setRewards(String rewards) {
		this.rewards = rewards;
	}
	public int getOnlineActive() {
		return onlineActive;
	}
	public void setOnlineActive(int onlineActive) {
		this.onlineActive = onlineActive;
	}

	
}
