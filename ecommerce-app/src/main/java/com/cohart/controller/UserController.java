package com.cohart.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String username, String password, String firstName, String lastName, String email) throws Exception {
		System.out.println("inside register method.."+username+", "+password+", "+firstName+", "+lastName+", "+email);
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?)");

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, firstName);
		pstmt.setString(4, lastName);
		pstmt.setString(5, email);
		
		pstmt.execute();
		
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password) throws Exception {
		
		System.out.println("The username is "+username+", the password is "+password);
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		
		PreparedStatement pstmt =  conn.prepareStatement("select * from user where username = ? and password = ?");
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			return "welcomePage";
		}
		else {
			return "index";
		}	
	}

}
