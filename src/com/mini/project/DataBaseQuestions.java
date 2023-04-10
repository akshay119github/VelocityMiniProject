package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseQuestions {

	public void getDataBaseQuestions() {

		try {
			System.out.println("<<< List of Questions >>>");
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection2 = connectionTest.getConnection();

			PreparedStatement preparedStatement = connection2
					.prepareStatement("select question, Option1, Option2, Option3, Option4, answer from questions");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Question. " +resultSet.getString(1));
				System.out.println("");
				System.out.println("1. " + resultSet.getString(2));
				System.out.println("2. " + resultSet.getString(3));
				System.out.println("3. " + resultSet.getString(4));
				System.out.println("4. " + resultSet.getString(5));
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
