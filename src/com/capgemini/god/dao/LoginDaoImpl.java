package com.capgemini.god.dao;

import java.sql.*;
import com.capgemini.god.dto.Login;
import com.capgemini.god.util.DatabaseUtil;

public class LoginDaoImpl implements LoginDao{
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;

	public LoginDaoImpl() throws SQLException {
		connection = DatabaseUtil.myconnection();
	}

	@Override
	public boolean LoginUser(Login login) throws SQLException {
		pst = connection.prepareStatement
	("select * from login where id=? and password=? and usertype=?");
		pst.setString(1, login.getId());
		pst.setString(2, login.getPassword());
		pst.setString(3, login.getUserType());
		System.out.println(login);

		rs = pst.executeQuery();
		if (rs.next())
			return true;
		else
			return false;
	}

	@Override
	public boolean RegisterUser(Login login) throws SQLException {
		pst = connection.prepareStatement
				("insert into login values(?,?,?)" );
					pst.setString(1, login.getId());
					pst.setString(2, login.getPassword());
					pst.setString(3, login.getUserType());

					int res = pst.executeUpdate();
					if (res==1)
						return true;
					else
						return false;
	}

}
