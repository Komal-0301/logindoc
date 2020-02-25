package com.capgemini.god.Controller;

public class LoginController {
	public void ConrolPage(String user) {
		if(user.equals("admin")) {
		//AdminPage admin=new AdminPage();
		  //admin.show();
			System.out.println("you can work as an admin");
		}
		
		else if(user.equals("user")) {
			//UserPage user=new UserPage();
			  //user.show();
			System.out.println("you can work as a user");
		}
	}
}
