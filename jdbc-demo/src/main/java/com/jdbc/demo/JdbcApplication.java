package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApplication {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost:3306/jdbc_demo";
		final String username = "root";
		final String password = "password";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connected to database server " + connection.getMetaData().getDatabaseProductName()
					+ " version: " + connection.getMetaData().getDatabaseProductVersion());

			// Create/Insert data in the DataBase Table - USER

			System.out.println("Creating/Inserting data into the Table");
			String query = "insert into USER values(?,?,?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, 1001);
				preparedStatement.setString(2, "Goutham");
				preparedStatement.setString(3, "Gunji");

				preparedStatement.execute();
				System.out.println("A record is successfully inserted in DB");

				preparedStatement.setInt(1, 1002);
				preparedStatement.setString(2, "James");
				preparedStatement.setString(3, "Andrew");

				System.out.println(preparedStatement.execute());

				System.out.println("A record is successfully inserted in DB");

			}

			// Read or Retrieve the data from DataBase - USER
			try (Statement statement = connection.createStatement()) {
				// read the full Table
				query = "select * from USER";
				ResultSet resultSet = statement.executeQuery(query);
				System.out.println("Data in the Table :");
				printResultset(resultSet);

				// read the single data
				query = """
						Select *
						from USER
						where id = ?""";
				try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
					preparedStatement.setInt(1, 101);
					System.out.println(" Read Data with specific ID : 101 ");
					if (resultSet.next() == false) {
						System.out.println("No Such Data exists");
					} else {
						resultSet = preparedStatement.executeQuery();
						printResultset(resultSet);
					}
				}

			}

			// Update the Data in Database Table - USER
			System.out.println("Updating the Table data :");
			query = """
					Update USER
					set first_name = ?
					where id = ?""";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, "Colin");
				preparedStatement.setInt(2, 1002);

				int rowsUpdated = preparedStatement.executeUpdate();
				if (rowsUpdated > 0)
					System.out.println("Rows Updated : " + rowsUpdated);
				else
					System.out.println("No data is updated");
			}

			// Delete the data from Table - USER
			System.out.println("Deleting the date from Table");
			query = """
					delete from USER where id = ?""";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, 1001);

				int rowsDeleted = preparedStatement.executeUpdate();
				if (rowsDeleted > 0)
					System.out.println("Rows Updated : " + rowsDeleted);
				else
					System.out.println("No data is deleted");

			}

		}

	}

	private static void printResultset(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");

			System.out.println("id : " + id + " firstName : " + firstName + " lastName : " + lastName);

		}

	}

}
