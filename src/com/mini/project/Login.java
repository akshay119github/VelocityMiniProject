package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	String uName = null;
	String pass = null;

	public void getLoginVerifiaction() throws SQLException {

		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection2 = connectionTest.getConnection();

			PreparedStatement preparedStatement = connection2
					.prepareStatement("select username from quiz where username=?");
			PreparedStatement preparedStatement2 = connection2
					.prepareStatement("select password from quiz where password=?");

			System.out.println("Already a member? Please Proceed Login");
			System.out.println("Enter the username:");
			Scanner scanner = new Scanner(System.in);
			String username = scanner.next();
			System.out.println("Enter the Password:");
			String password = scanner.next();

			preparedStatement.setString(1, username);
			preparedStatement2.setString(1, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				uName = resultSet.getString(1);
			}
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			while (resultSet2.next()) {
				pass = resultSet2.getString(1);
			}

			if (username.equals(uName) && password.equals(pass)) {
				ChooseAnswer chooseAnswer = new ChooseAnswer();
				chooseAnswer.ChooseCorrectAnswer();

			} else {
				System.out.println("Incorrect Login Credentials. Please verify username and password..OR..");
				System.out.println("Please Registered in JAVA QUIZ APPLICATION ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
