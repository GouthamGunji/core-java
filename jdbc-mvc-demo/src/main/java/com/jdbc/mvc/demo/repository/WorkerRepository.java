package com.jdbc.mvc.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.mvc.demo.dao.WorkerDao;
import com.jdbc.mvc.demo.model.Worker;
import com.jdbc.mvc.demo.util.DatabaseConnection;

public class WorkerRepository implements WorkerDao {
	private final Connection connection;

	public WorkerRepository(DatabaseConnection connection) {
		super();
		this.connection = connection.getConnection();
	}

	public Integer createWorker(Worker worker) throws SQLException {
		String insertWorkerFormat = """
				INSERT INTO Worker (
				    WORKER_ID,
				    FIRST_NAME,
				    LAST_NAME,
				    SALARY,
				    JOINING_DATE,
				    DEPARTMENT)
				VALUES (
				    ?, ?, ?, ?, NOW(), ?
				    )""";

		try (PreparedStatement preparedStatement = connection.prepareStatement(insertWorkerFormat);) {
			preparedStatement.setInt(1, worker.getWorkerId());
			preparedStatement.setString(2, worker.getFirstName());
			preparedStatement.setString(3, worker.getLastName());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.setString(5, worker.getDepartment());
			return preparedStatement.executeUpdate();
		}
	}

	public Worker findWorkerById(Integer id) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
		String getWorkerFormat = """
				SELECT *
				FROM
				    Worker
				WHERE
				    WORKER_ID = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getWorkerFormat);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Worker worker = new Worker();
			while (rs.next()) {
				worker.setWorkerId(rs.getInt("WORKER_ID"));
				worker.setFirstName(rs.getString("FIRST_NAME"));
				worker.setLastName(rs.getString("LAST_NAME"));
				worker.setSalary(rs.getInt("SALARY"));
				worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
				worker.setDepartment(rs.getString("DEPARTMENT"));
			}
			return worker;
		}
	}

	public List<Worker> findAllWorkers() throws SQLException {
		String getWorkersFormat = """
				SELECT *
				FROM
				    Worker""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Worker> workers = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return workers;
			}

			while (rs.next()) {
				Worker worker = new Worker();
				worker.setWorkerId(rs.getInt("WORKER_ID"));
				worker.setFirstName(rs.getString("FIRST_NAME"));
				worker.setLastName(rs.getString("LAST_NAME"));
				worker.setSalary(rs.getInt("SALARY"));
				worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
				worker.setDepartment(rs.getString("DEPARTMENT"));

				workers.add(worker);
			}

			return workers;
		}
	}

	public Integer updateWorker(Worker worker) throws SQLException {
		String updateWorkerFormat = """
				UPDATE Worker
				SET
				    DEPARTMENT = ?
				WHERE
				    WORKER_ID = ?""";

		try (PreparedStatement preparedStatement = connection.prepareStatement(updateWorkerFormat);) {
			preparedStatement.setString(1, worker.getDepartment());
			preparedStatement.setInt(2, worker.getWorkerId());
			return preparedStatement.executeUpdate();
		}
	}

	public Integer updateSalaryByDepartment(String department, Integer bonusFactor) throws SQLException {
		String updateSalaryByDepartmentFormat = """
				UPDATE Worker
				SET
					SALARY = SALARY * ?
				WHERE
					DEPARTMENT = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(updateSalaryByDepartmentFormat)) {
			preparedStatement.setInt(1, bonusFactor);
			preparedStatement.setString(2, department);

			return preparedStatement.executeUpdate();

		}

	}

	public Integer deleteWorkerById(Integer id) throws SQLException {
		String deleteWorkerFormat = """
				DELETE FROM Worker
				WHERE
				    WORKER_ID = ?""";

		try (PreparedStatement preparedStatement = connection.prepareStatement(deleteWorkerFormat);) {
			preparedStatement.setInt(1, 10);
			return preparedStatement.executeUpdate();
		}
	}
}