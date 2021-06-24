package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.services;

import java.util.List;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;
import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Cards;

public interface CardsService {
	
	List<Cards> CardsByAccountNumber(String accountNumber);
	
    String findCardNumber(String userName);
    

}
