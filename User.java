package com.atmprocess;

import java.util.Scanner;

public class User implements AtmProcess {
	static Scanner sc = new Scanner(System.in);
	private String name;
	private long acc_No;
	private int pin;
	private double balance = 1000.0;

	User() {
		super();
	}

	User(String name, long acc_No, int pin) {
		this.name = name;
		this.acc_No = acc_No;
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public long getAcc_No() {
		return acc_No;
	}

	public int getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}
	@Override
	public void checkBalance() {

		System.out.println("Current Balance: $" + balance);
	}

	@Override
	public void deposit() {
		System.out.println("Enter amount to deposite: ");
		double amount = sc.nextDouble();
		if (amount > 0) {
			balance += amount;
			System.out.println("Sucessfully Deposited $" + amount);
			System.out.println("Current Balance: $" + balance);
		} else {
			System.out.println("Invalid Deposite.");
		}
	}

	@Override
	public void withdraw() {
		System.out.println("Enter amount to withdraw: ");
		double amount = sc.nextDouble();
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdraw sucessfull.");
			System.out.println("Current Balance: " + balance);
		} else if (amount <= 0) {
			System.out.println("Invalid withdraw amount.");
		} else {

			System.out.println("Insufficient balance.");
		}
	}

	public void exit() {
		System.out.println("Thanks for using the ATM!");
	}

	@Override
	public void pinChange() {

		System.out.print("Enter your current PIN: ");
        int currentPin = sc.nextInt();

        if (currentPin == pin) {
            System.out.print("Enter new PIN: ");
            int newPin = sc.nextInt();
            System.out.print("Confirm new PIN: ");
            int confirmPin = sc.nextInt();

            if (newPin == confirmPin) {
                pin = newPin;
                System.out.println("PIN successfully updated.");
            } else {
                System.out.println("PINs do not match. Please try again.");
            }
        } else {
            System.out.println("Incorrect current PIN.");
        }
	}

}
