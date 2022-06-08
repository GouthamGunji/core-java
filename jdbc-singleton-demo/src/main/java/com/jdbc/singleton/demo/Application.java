package com.jdbc.singleton.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.singleton.demo.beans.User;
import com.jdbc.singleton.demo.controller.CrudController;

public class Application {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CrudController controller = context.getBean("crudController", CrudController.class);

		// Performing the CRUD Operations
		// 1. create data into the User Table
		User user = new User(101, "Lakshya", "S");

		System.out.println(controller.create(user));

		// 2. Read the entire data in data base
		ResultSet rs = controller.readAll();
		displayResultset(rs);

		// 3. Update the User Last name for specific Id
		int id = 101;
		String lastName = "Sen";
		System.out.println(controller.update(id, lastName));

		// 4. delete the data in table with specific id
		int deleteId = 101;
		System.out.println(controller.delete(deleteId));

		context.close();

	}

	private static void displayResultset(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			User user = new User(id, firstName, lastName);

			System.out.println(user);

		}
	}

}
