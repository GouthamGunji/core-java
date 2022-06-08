package com.jdbc.mvc.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection connection = null;

	public DatabaseConnection(String url, String userName, String password) throws SQLException {
		super();
		this.connection = DriverManager.getConnection(url, userName, password);
	}

	public Connection getConnection() {
		return connection;
	}

}
