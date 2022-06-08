package com.jdbc.singleton.demo.util;

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
	
	

	/*
	 * public static Connection getConnection() throws Exception {
	 * 
	 * if (instance == null) { System.out.println("creating a new Instance");
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * ApplicationContext context = new
	 * ClassPathXmlApplicationContext("applicationContext.xml"); DatabaseConnection
	 * dbConnection = (DatabaseConnection) context.getBean("DBConnection"); instance
	 * = DriverManager.getConnection(dbConnection.getUrl(),
	 * dbConnection.getUserName(), dbConnection.getPassword()); }
	 * 
	 * return instance;
	 * 
	 * }
	 */
}
