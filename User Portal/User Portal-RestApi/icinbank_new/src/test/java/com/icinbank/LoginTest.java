package com.icinbank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.icinbank.details.LoginDetails;
import com.icinbank.response.LoginResponse;
import com.icinbank.service.LoginService;
import com.icinbank.service.impl.LoginServiceImpl;

class LoginTest {
  

	
	private LoginDetails loginDetails = new LoginDetails();
	
	
	private LoginResponse loginResponse = new LoginResponse();
	
	
	private LoginService LoginServiceImpl = new LoginServiceImpl();
	
	@Test
	public void Login_Test() {
		
		loginDetails.setUsername("sah123");
		loginDetails.setPassword("123456");
		loginResponse.setLoginStatus(true);
		
		LoginResponse loginResponseActual = LoginServiceImpl.customerLogin(loginDetails);
		assertEquals("Some Exception Occured!", loginResponseActual.getResponseMessage());
		
		
	}

}
