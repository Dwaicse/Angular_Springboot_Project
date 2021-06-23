package com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.rest.onlinebankingservices.onlinebankingRestApi.controller.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, Long> {

}
