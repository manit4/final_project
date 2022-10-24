package com.cohart.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cohart.db.DBUtils;

public class UserRepository {

	public void save(String username, String password, String firstName, String lastName, String email) throws Exception {

		Connection conn = DBUtils.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?)");

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, firstName);
		pstmt.setString(4, lastName);
		pstmt.setString(5, email);

		pstmt.execute();
	}
	
	public boolean getUser(String username, String password) throws Exception {
		
		boolean loginStatus = false;
		
		Connection conn = DBUtils.getConnection();	
		PreparedStatement pstmt =  conn.prepareStatement("select * from user where username = ? and password = ?");
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			loginStatus = true;
		}
		return loginStatus;
	}

}
