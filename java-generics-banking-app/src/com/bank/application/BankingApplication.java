package com.bank.application;

import java.util.Scanner;

import com.bank.application.entity.AccountType;
import com.bank.application.entity.BankAccount;
import com.bank.application.entity.CurrentAccount;
import com.bank.application.entity.SavingsAccount;

public class BankingApplication {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(" Welcome to the Banking Application");
		System.out.println("Select the account : \n");
		System.out.println("\t 1. Savings Account");
		System.out.println("\t 2. Current Account");
		System.out.print("Choose your Option : ");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			savingsAccountServices();
			break;

		case 2:
			currentAccountServices();
			break;

		default:
			System.out.println("Invalid Option selected ");
			break;
		}

		sc.close();

	}

	private static void currentAccountServices() {
		// TODO Auto-generated method stub

		CurrentAccount account = new CurrentAccount();

		BankAccount<AccountType> bankAccount = new BankAccount<>(account);
		bankAccount.showAccountType();

		boolean exit = false;

		while (!exit) {
			displayAccountOptions();

			System.out.print("Select your option : ");
			int selection = sc.nextInt();
			System.out.println();
			switch (selection) {
			case 1:
				depositAmount(account);
				break;

			case 2:
				withdrawAmount(account);
				break;

			case 3:
				account.showBalance();
				break;

			case 4:
				exit = true;
				break;

			default:
				System.out.println("Invalid option selected !!!");
				break;
			}

		}

		System.out.println("You have successfully logged out !!!");

	}

	private static void savingsAccountServices() {
		// TODO Auto-generated method stub

		SavingsAccount account = new SavingsAccount();

		BankAccount<AccountType> bankAccount = new BankAccount<>(account);
		bankAccount.showAccountType();

		boolean exit = false;

		while (!exit) {
			displayAccountOptions();
			System.out.print("Select your option : ");
			int selection = sc.nextInt();
			System.out.println();
			switch (selection) {
			case 1:
				depositAmount(account);
				break;

			case 2:
				withdrawAmount(account);
				break;

			case 3:
				account.showBalance();
				break;

			case 4:
				exit = true;
				break;

			default:
				System.out.println("Invalid option selected !!!");
				break;
			}

		}

		System.out.println("You have successfully logged out !!!");

	}

	private static void displayAccountOptions() {
		// TODO Auto-generated method stub
		System.out.println("Available Options : ");
		System.out.println("\t 1. Deposit Amount ");
		System.out.println("\t 2. WithDraw Amount ");
		System.out.println("\t 3. Show Balance ");
		System.out.println("\t 4. Exit ");

	}

	private static void depositAmount(AccountType account) {
		System.out.print("Enter amount to be Deposited : ");

		// checking the generic functionality in java by giving float value
		Float depositAmount = sc.nextFloat();
		account.deposit(depositAmount);

	}

	private static void withdrawAmount(AccountType account) {
		System.out.print("Enter Withdraw Amount : ");
		Float withdrawAmount = sc.nextFloat();
		account.withdraw(withdrawAmount);
	}

}
