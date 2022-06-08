package com.jdbc.mvc.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.mvc.demo.controller.WorkerController;

public class Application {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();
		System.out.println("Spring JDBC app with MySQL Connector works!\n");

		WorkerController workerController = context.getBean("workerController", WorkerController.class);

		System.out.println("Creating a new worker record::");
		System.out.println(workerController.create(10, "Tony", "Stark", 50000000, "R&D") + "\n");

		System.out.println("Retrieving a worker record::");
		System.out.println(workerController.get(10) + "\n");

		System.out.print("Retrieving all worker records::");
		System.out.println(workerController.getAll() + "\n");

		System.out.println("Updating a worker record::");
		System.out.println(workerController.update("Boss", 10));
		System.out.println("Retrieving the worker record after updation::");
		System.out.println(workerController.get(10) + "\n");

		System.out.println("Updating the Salary of Worker By Department ::");
		System.out.println(workerController.updateSalaryByDepartment("HR", 2));
		System.out.println("Retrieving the worker record after updation::");
		System.out.println(workerController.getAll() + "\n");

		System.out.println("Deleting a worker record::");
		System.out.println(workerController.delete(10) + "\n");
		System.out.print("Retrieving all worker records after deletion::");
		System.out.println(workerController.getAll() + "\n");

		context.close();

	}

}
