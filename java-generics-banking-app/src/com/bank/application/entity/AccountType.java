package com.bank.application.entity;

public interface AccountType {

	<U extends Number> void withdraw(U amount);

	<U extends Number> void deposit(U amount);

	void showBalance();

}
