package com.jdbc.mvc.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.mvc.demo.dao.BonusDao;
import com.jdbc.mvc.demo.model.Bonus;
import com.jdbc.mvc.demo.util.DatabaseConnection;

public class BonusRepository implements BonusDao {

	private Connection connection;

	public BonusRepository(DatabaseConnection dbConnection) {
		this.connection = dbConnection.getConnection();
	}

	@Override
	public Integer addBonus(Bonus bonus) throws SQLException {
		String addBonusFormat = """
				INSERT into	Bonus(
					WORKER_REF_ID,
					BONUS_AMOUNT,
					BONUS_DATE)
				values (?,?,NOW())""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(addBonusFormat)) {
			preparedStatement.setInt(1, bonus.getWorkerId());
			preparedStatement.setDouble(2, bonus.getBonusAmount());

			return preparedStatement.executeUpdate();

		}

	}

	@Override
	public List<Bonus> findAllWorkersBonusDetails() throws SQLException {
		String getBonusDetailsFormat = """
				SELECT *
				FROM
					Bonus""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getBonusDetailsFormat)) {

			ResultSet rs = preparedStatement.executeQuery();

			List<Bonus> bonusList = new ArrayList<>();

			if (!rs.isBeforeFirst())
				return bonusList;

			while (rs.next()) {
				Integer workerID = rs.getInt("WORKER_REF_ID");
				Double bonusAmount = rs.getDouble("BONUS_AMOUNT");
				Timestamp bonusDate = rs.getTimestamp("BONUS_DATE");

				Bonus bonus = new Bonus(workerID, bonusAmount, bonusDate);

				bonusList.add(bonus);

			}

			return bonusList;
		}

	}

	@Override
	public Bonus findByWorkerIdBonusDetails(Integer workerId) throws SQLException {
		String getBonusByWorkerIdFormat = """
				SELECT *
				FROM
					Bonus
				WHERE
					WORKER_REF_ID = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getBonusByWorkerIdFormat)) {
			preparedStatement.setInt(1, workerId);
			ResultSet rs = preparedStatement.executeQuery();

			Bonus bonus = new Bonus();

			if (!rs.isBeforeFirst())
				return bonus;

			while (rs.next()) {
				bonus.setWorkerId(rs.getInt("WORKER_REF_ID"));
				bonus.setBonusAmount(rs.getDouble("BONUS_AMOUNT"));
				bonus.setBonusDate(rs.getTimestamp("BONUS_DATE"));

			}

			return bonus;

		}
	}

	@Override
	public Integer updateWorkerBonusDetails(Bonus bonus) throws SQLException {
		String updateBonusDetailFormat = """
				UPDATE
					BONUS
				SET
					BONUS_AMOUNT = ?,
					BONUS_DATE = NOW()
				WHERE
					WORKER_REF_ID = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(updateBonusDetailFormat)) {
			preparedStatement.setDouble(1, bonus.getBonusAmount());
			preparedStatement.setInt(2, bonus.getWorkerId());

			return preparedStatement.executeUpdate();

		}

	}

	@Override
	public Integer deleteWorkerBonusDetails(Integer workerId) throws SQLException {
		String deleteBonusDetailFormat = """
				DELETE FROM
					BONUS
				WHERE
					WORKER_REF_ID = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBonusDetailFormat)) {
			preparedStatement.setInt(1, workerId);

			return preparedStatement.executeUpdate();

		}

	}

}
