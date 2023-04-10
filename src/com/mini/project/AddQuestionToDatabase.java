package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AddQuestionToDatabase {

	public void addQuestionToDataBase() {

		String uName = null;
		String pass = null;

		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection5 = connectionTest.getConnection();

			PreparedStatement preparedStatement = connection5
					.prepareStatement("select username from admin where username=?");
			PreparedStatement preparedStatement2 = connection5
					.prepareStatement("select password from admin where password=?");

			System.out.println("Plese Enter Admin Login Credintials");
			System.out.println("Enter the username: admin");
			Scanner scanner = new Scanner(System.in);
			String username = scanner.next();
			System.out.println("Enter the Password: admin");
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

				PreparedStatement preparedStatement3 = connection5.prepareStatement(
						"insert into questions(question, Option1, Option2, Option3, Option4, answer) values (?,?,?,?,?,?);");
				
				System.out.println("Enter the Question:");
				String question = scanner.next();
				System.out.println("Enter the Option 1:");
				String option1 = scanner.next();
				System.out.println("Enter the Option 2:");
				String option2 = scanner.next();
				System.out.println("Enter the Option 3:");
				String option3 = scanner.next();
				System.out.println("Enter the Option 4:");
				String option4 = scanner.next();
				System.out.println("Enter the Correct Answer:");
				int ans = scanner.nextInt();

				preparedStatement3.setString(1, question);
				preparedStatement3.setString(2, option1);
				preparedStatement3.setString(3, option2);
				preparedStatement3.setString(4, option3);
				preparedStatement3.setString(5, option4);
				preparedStatement3.setInt(6, ans);

				int k = preparedStatement3.executeUpdate();
				System.out.println("Question with Option and Correct Answer is inserted succesfully...");

			} else {
				System.out.println("Incorrect Login Credentials. Please verify username and password.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
