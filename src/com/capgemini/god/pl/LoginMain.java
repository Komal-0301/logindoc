package com.capgemini.god.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.god.Exception.LoginException;
import com.capgemini.god.service.LoginService;
import com.capgemini.god.service.LoginServiceImpl;

public class LoginMain {
public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("login or register");
		String input=scanner.nextLine();
		if(input.equals("login")) {
		try {
			LoginService loginService=new LoginServiceImpl();
			loginService.userLogin();
			
		} catch (SQLException|LoginException e) {
		System.err.println(e.getMessage());
			
			//e.printStackTrace();
		}
		}
		if(input.equals("register")) {
			try {
				LoginService loginService=new LoginServiceImpl();
				loginService.userRegister();
				
			} catch (SQLException|LoginException e) {
			System.err.println(e.getMessage());

				//e.printStackTrace();
			}
		}
	}
}
