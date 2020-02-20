package com.capgemini.god.dao;

import java.sql.SQLException;

import com.capgemini.god.dto.Login;

public interface LoginDao {
	public boolean LoginUser(Login login)  throws SQLException;
	public boolean RegisterUser(Login register)  throws SQLException;
}
