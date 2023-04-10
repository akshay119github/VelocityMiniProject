package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayResult {

	public void getDisplayResult() {
		
		String uName = null;
		String pass = null;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection4 =connectionTest.getConnection();
			
			PreparedStatement preparedStatement = connection4.prepareStatement("select username from quizresult where username=?");
			PreparedStatement preparedStatement2 = connection4.prepareStatement("select password from quizresult where password=?");
			PreparedStatement preparedStatement3 = connection4.prepareStatement("select result from quizresult where username=?");
			
			System.out.println("Already a member? Please Proceed Login");
			System.out.println("Enter the username:");
			Scanner scanner = new Scanner(System.in);
			String username = scanner.next();
			System.out.println("Enter the Password:");
			String password = scanner.next();
			
			preparedStatement.setString(1, username);
			preparedStatement2.setString(1, password);
			preparedStatement3.setString(1, username);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			    uName = resultSet.getString(1);
			}
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			while(resultSet2.next()) {
				pass = resultSet2.getString(1);
			}
			
			if(username.equals(uName) && password.equals(pass)) {
				ResultSet resultSet3 = preparedStatement3.executeQuery();
				while(resultSet3.next()) {
					System.out.println("Score is " +resultSet3.getInt(1));
				}
				
			} else {
				System.out.println("Incorrect Login Credentials. Please verify username and password..OR..");
				System.out.println("Please Registered in JAVA QUIZ APPLICATION ");
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
