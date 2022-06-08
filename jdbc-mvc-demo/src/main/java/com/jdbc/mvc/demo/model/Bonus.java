package com.jdbc.mvc.demo.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Bonus implements Comparable<Bonus> {

	private Integer workerId;
	private Double bonusAmount;
	private Timestamp bonusDate;

	public Bonus(Integer workerId, Double bonusAmount, Timestamp bonusDate) {
		super();
		this.workerId = workerId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
	}

	public Bonus(Integer workerId, Double bonusAmount) {
		super();
		this.workerId = workerId;
		this.bonusAmount = bonusAmount;
	}

	public Bonus() {
		super();
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public Double getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Timestamp getBonusDate() {
		return bonusDate;
	}

	public void setBonusDate(Timestamp bonusDate) {
		this.bonusDate = bonusDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(workerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bonus other = (Bonus) obj;
		return Objects.equals(workerId, other.workerId);
	}

	@Override
	public String toString() {
		return "Bonus [workerId=" + workerId + ", bonusAmount=" + bonusAmount + ", bonusDate=" + bonusDate + "]";
	}

	@Override
	public int compareTo(Bonus o) {
		return this.workerId - o.workerId;
	}

}
