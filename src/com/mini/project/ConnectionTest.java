package com.mini.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapplication", "root", "Mysql123*");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return connection;
	}

}
