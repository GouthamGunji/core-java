package com.jdbc.mvc.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.mvc.demo.model.Bonus;

public interface BonusDao {

	public Integer addBonus(Bonus bonus) throws SQLException;

	public List<Bonus> findAllWorkersBonusDetails() throws SQLException;

	public Bonus findByWorkerIdBonusDetails(Integer workerId) throws SQLException;

	public Integer updateWorkerBonusDetails(Bonus bonus) throws SQLException;

	public Integer deleteWorkerBonusDetails(Integer workerId) throws SQLException;

}
