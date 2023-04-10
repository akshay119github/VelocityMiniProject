package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class IDResult {
	
	public void getIDResult() {
		
		String uName = null;
		String pass = null;
		
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection6 =connectionTest.getConnection();
			
			PreparedStatement preparedStatement = connection6.prepareStatement("select username from admin where username=?");
			PreparedStatement preparedStatement2 = connection6.prepareStatement("select password from admin where password=?");
			
			System.out.println("Plese Enter Admin Login Credintials");
			System.out.println("Enter the username: admin");
			Scanner scanner = new Scanner(System.in);
			String username = scanner.next();
			System.out.println("Enter the Password: admin");
			String password = scanner.next();
			
			preparedStatement.setString(1, username);
			preparedStatement2.setString(1, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			    uName = resultSet.getString(1);
			}
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			while(resultSet2.next()) {
				pass = resultSet2.getString(1);
			}
			
			if(username.equals(uName) && password.equals(pass)) {
			
				PreparedStatement preparedStatement3 = connection6.prepareStatement("select result from quizresult where id=?;");
				System.out.println("Enter the Student ID:");
				int id = scanner.nextInt();
				preparedStatement3.setInt(1, id);
				ResultSet resultSet3 = preparedStatement3.executeQuery();
				while(resultSet3.next()) {
				    System.out.println("Score: " +resultSet3.getInt(1));
				}
				
			} else {
				System.out.println("Incorrect Login Credentials. Please verify username and password.");
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
