package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.AccountDetails;

public interface AccountDao extends JpaRepository<AccountDetails, String> {
	AccountDetails findByUsername(String username);
	AccountDetails findByEmail(String email);
	

	

}
