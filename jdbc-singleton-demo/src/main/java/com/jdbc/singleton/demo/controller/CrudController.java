package com.jdbc.singleton.demo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.singleton.demo.beans.User;
import com.jdbc.singleton.demo.util.DatabaseConnection;

public class CrudController {

	private String query;
	private Connection connection;

	public CrudController(DatabaseConnection connection) {
		super();
		this.connection = connection.getConnection();
	}

	public String create(User user) throws Exception {

		System.out.println("Connected to database server " + connection.getMetaData().getDatabaseProductName()
				+ " version: " + connection.getMetaData().getDatabaseProductVersion());
		query = "insert into USER values(?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			if (!preparedStatement.execute()) {
				return "Record inserted successfully";
			} else {
				return "Error in inserting the data";
			}
		}
	}

	public ResultSet readAll() throws Exception {

		query = "select * from USER";
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);

	}

	public String update(int id, String lastName) throws Exception {

		query = """
				update USER
				set last_name = ?
				where id=?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, lastName);

			int i = preparedStatement.executeUpdate();

			if (i > 0)
				return "No.of Rows updated : " + i;
			else
				return "no specific Data exist to update";
		} catch (SQLException e) {
			return "Error in SQL connection";
		}

	}

	public String delete(int id) throws Exception {

		query = """
				delete from
				USER
				where id = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			if (!preparedStatement.execute())
				return "Record deleted successfully";
			else
				return "Unable to delete data or Data already deleted";
		}

	}

}
