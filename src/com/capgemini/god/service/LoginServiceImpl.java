package com.capgemini.god.service;

import java.io.Console;
import java.sql.SQLException;

import com.capgemini.god.Controller.LoginController;
import com.capgemini.god.Exception.LoginException;
import com.capgemini.god.dao.LoginDao;
import com.capgemini.god.dao.LoginDaoImpl;
import com.capgemini.god.dto.Login;

public class LoginServiceImpl implements LoginService {

	Login login;
	Console console;
	LoginDao dao;
	Login register;

	public LoginServiceImpl() throws SQLException {
		console = System.console();
		dao = new LoginDaoImpl();
	}

	@Override
	public void userLogin() throws LoginException, SQLException {
		if (console == null)
			System.out.println("console is null");

		login = new Login();
		System.out.println("Enter Id");
		login.setId(console.readLine());

		System.out.println("Enter Password");
		login.setPassword(console.readPassword().toString());

		System.out.println("Re Enter Password");
		String s = new String(console.readPassword());
		login.setPassword(s);

		boolean status = false;
		if (!s.equals(login.getPassword())) {
			System.err.println("Renter password is wrong");
			status = true;
		}

		if (status) {
			System.out.println("Renter password again");
			s = console.readPassword().toString();
			login.setPassword(s);
		}
		if (!s.equals(login.getPassword()))
			throw new LoginException("Re-enter password wrong Login Denied");

		System.out.println("Enter UserType Admin or User");
		login.setUserType(console.readLine());

		if (dao.LoginUser(login)) {
			System.out.println("user login successfull");
			LoginController lc=new LoginController();
			lc.ConrolPage(s);
		} else
			System.err.println("login denied either id or password problem");

	}

	@Override
	public void userRegister() throws LoginException, SQLException {
		register = new Login();
		String s;
		System.out.println("Enter Id");
		register.setId(console.readLine());

		System.out.println("enter phone no");
		s=console.readLine();
		if(s.matches("\\d{10}"))
		register.setPhoneNo(s);
		else
			throw new LoginException("invalid phone no");

		System.out.println("enter Email Id");
		s=console.readLine();
		if(s.matches("^(.+)@(.+)$"))
		register.setEmail(s);
		else
			throw new LoginException("invalid email id");

		System.out.println("Enter Password");
		register.setPassword(console.readPassword().toString());

		System.out.println("Re Enter Password");
		String p = new String(console.readPassword());
		register.setPassword(p);

		boolean status = false;
		if (!p.equals(register.getPassword())) {
			System.err.println("Renter password is wrong");
			status = true;
		}

		if (status) {
			System.out.println("Re-enter password again");
			s = console.readPassword().toString();
			register.setPassword(s);
		}
		if (!p.equals(register.getPassword()))
			throw new LoginException("Re-enter password wrong Login Denied");

		System.out.println("Enter UserType Admin or User");
		register.setUserType(console.readLine());

		if (dao.RegisterUser(register)) {
			System.out.println("registered successfully");
		} else
			System.err.println("registeration denied either id or password problem");
	}

}
