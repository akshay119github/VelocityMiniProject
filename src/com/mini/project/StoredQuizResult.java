package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoredQuizResult {
	
	public void getStoredQuizResult() throws SQLException {
		Login login = new Login();
		ChooseAnswer chooseAnswer = new ChooseAnswer();
		
		ConnectionTest connectionTest = new ConnectionTest();
		Connection connection3 = connectionTest.getConnection();
		
		login.getLoginVerifiaction();
		
		PreparedStatement preparedStatement = connection3.prepareStatement("insert into quizresult(username, password, result) values(?,?,?)");
		preparedStatement.setString(1, login.uName);
		preparedStatement.setString(2, login.pass);
		preparedStatement.setInt(3, chooseAnswer.count);
		
		int j = preparedStatement.executeUpdate();
		System.out.println("Quiz Result Successfully Stored");
	}

}
