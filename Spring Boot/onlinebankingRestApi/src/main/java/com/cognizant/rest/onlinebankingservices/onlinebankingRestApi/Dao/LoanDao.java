package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Loan;

public interface LoanDao extends JpaRepository<Loan, Long> {

}
