package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Cards;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.AccountDetailsService;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services.CardsService;

@Service
public class CardsServiceimpl implements CardsService {
	
	
	@Autowired
	private AccountDetailsService accountDetailsService;

	@Override
	public List<Cards> CardsByAccountNumber(String accountNumber) {
		AccountDetails aDetails = accountDetailsService.findByAccountNumber(accountNumber);
		List<Cards> cardsList = aDetails.getCardsList();
		return cardsList;
	}
	
	

}
