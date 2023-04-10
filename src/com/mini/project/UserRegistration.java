package com.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

	public void getUserDetails() throws SQLException {
		
		Connection connection1 = null;
		PreparedStatement preparedStatement = null;
		
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			connection1 = connectionTest.getConnection();
			
			preparedStatement = connection1.prepareStatement("insert into quiz(firstname, lastname, username, password, city, email, mobilenumber) values(?,?,?,?,?,?,?)");
			
			System.out.println("Welocome to JAVA QUIZ APPLICATION");
			System.out.println("Enter the first name:");
			Scanner scanner = new Scanner(System.in);
			String firstname = scanner.next();
			System.out.println("Enter the last name");
			String lastname = scanner.next();
			System.out.println("Enter the username:");
			String username = scanner.next();
			System.out.println("Enter the Password:");
			String password = scanner.next();
			System.out.println("Enter the City:");
			String city = scanner.next();
			System.out.println("Enter the Mail Id:");
			String email = scanner.next();
			System.out.println("Enter the Mobile Number:");
			String mobilenumber = scanner.next();
			
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, mobilenumber);
			
			int i = preparedStatement.executeUpdate();
			System.out.println("...Successfully Registered...Please Login...");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection1.close();
			preparedStatement.close();
		}
		} 
	}
	
