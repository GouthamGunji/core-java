package com.bank.application.entity;

public class BankAccount<T extends AccountType> {

	private T accountType;

	public T getAccountType() {
		return accountType;
	}

	public void setAccountType(T accountType) {
		this.accountType = accountType;
	}

	public BankAccount(T accountType) {
		super();
		this.accountType = accountType;
	}

	public void showAccountType() {
		System.out.println(" Account Type : " + accountType.getClass().getSimpleName());

	}

}
