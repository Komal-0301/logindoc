package com.capgemini.god.service;

import java.sql.SQLException;

import com.capgemini.god.Exception.LoginException;

public interface LoginService {
	public void userLogin() throws LoginException, SQLException;
	public void userRegister() throws LoginException, SQLException;
	
}
