package com.bank.application.entity;

import java.text.DecimalFormat;

public class SavingsAccount implements AccountType {

	private static final double INTEREST_RATE = 0.4;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	private double availableBalance;

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public SavingsAccount(double availableBalance) {

		this.availableBalance = availableBalance;
	}

	public SavingsAccount() {

	}

	@Override
	public <U extends Number> void withdraw(U amount) {

		if (amount.doubleValue() > availableBalance) {
			System.out.println(" InSufficient Balance");
		} else {
			availableBalance = availableBalance - amount.doubleValue();
			System.out.println("Your Account is succesfully debited with INR : " + df.format(amount.doubleValue()));
		}
		System.out.println("Total Available Balance : " + df.format(availableBalance));
	}

	@Override
	public <U extends Number> void deposit(U amount) {
		availableBalance = availableBalance + amount.doubleValue();
		System.out.println("Your Account is successfully credited with INR : " + amount.doubleValue());
		System.out.println("Total Available Balance : " + df.format(availableBalance));

	}

	@Override
	public void showBalance() {
		System.out.println("Total Available Balance : " + df.format(availableBalance));
		System.out.println("Annual Interest calculated : " + df.format(availableBalance * INTEREST_RATE));
	}

}
