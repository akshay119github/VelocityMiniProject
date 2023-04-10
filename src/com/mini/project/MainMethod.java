package com.mini.project;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) throws SQLException {
		System.out.println("<<< Welocome to JAVA QUIZ APPLICATION >>>\r\n" +"");
		
		System.out.println("User Operation\r\n" + "1. Student Registration\r\n" + "2. Student Login\r\n"
				+ "3. Display the list of questions\r\n" + "4. Solve the Quiz & Store Quiz result into database\r\n"
				+ "5. Display Quiz result ");
		System.out.println("");
		System.out.println("Admin Operation\r\n" + "6. Display all students score as per ascending order\r\n"
				+ "7. Fetch student score by using id\r\n" +"8. Add question with 4 options into database");
		System.out.println("");
		System.out.println("Enter the Choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Please Registered");
			UserRegistration userRegistration = new UserRegistration();
			userRegistration.getUserDetails();
			break;

		case 2:
			System.out.println("Login in to the Account >");
			DuplicateLogin duplicateLogin = new DuplicateLogin();
			duplicateLogin.getLoginVerifiaction();
			break;

		case 3:
			System.out.println("Display the list of questions");
			DuplicateLogin duplicateLogin2 = new DuplicateLogin();
			duplicateLogin2.getLoginVerifiaction();
			break;

		case 4:
			System.out.println("Solve the Quiz and Store Quiz result into database");
			StoredQuizResult storedQuizResult = new StoredQuizResult();
			storedQuizResult.getStoredQuizResult();
			break;

		case 5:
			System.out.println("Display Quiz result");
			DisplayResult displayResult = new DisplayResult();
			displayResult.getDisplayResult();
			break;

		case 6:
			System.out.println("Display all students score as per ascending order");
			AscendingOrder ascendingOrder = new AscendingOrder();
			ascendingOrder.getAscendingOrder();
			break;

		case 7:
			System.out.println("Fetch student score by using id");
			IDResult idResult = new IDResult();
			idResult.getIDResult();
			break;
			
		case 8:
			System.out.println("Add question with 4 options into database");
			AddQuestionToDatabase addQuestionToDatabase = new AddQuestionToDatabase();
			addQuestionToDatabase.addQuestionToDataBase();
			break;

		default:
			System.out.println("Incorrect Choice");
			break;
		}

	}

}
