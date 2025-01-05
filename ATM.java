package com.atmprocess;

import java.util.Scanner;

interface AtmProcess {
	void checkBalance();

	void deposit();

	void withdraw();

	void pinChange();
} 

public class ATM {

	static String status;

	public static void main(String[] args) {

		User[] u = new User[3];
		u[0] = new User("Gnaneshwar", 37909668214L, 2003);
		u[1] = new User("Jothibabu", 123456789L, 1234);
		u[2] = new User("Santosh", 1234567890L, 5678);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number: ");
		long accNo = sc.nextLong();
		System.out.println("Enter PIN Number: ");
		int atmPin = sc.nextInt();
		User currentUser = null;
		for (User user : u) {
			if (user.getAcc_No() == accNo && user.getPin() == atmPin) {
				currentUser = user;
				break;
			}
		}

		if (currentUser != null) {
			do {
				System.out.println("Enter your Choice: ");
				System.out.println(" 1. Check Balance \n 2. Deposit \n 3. Withdraw \n 4. Pin Change \n 5. Exit");
				int x = sc.nextInt();
				switch (x) {
				case 1:
					currentUser.checkBalance();
					break;
				case 2:
					currentUser.deposit();
					break;
				case 3:
					currentUser.withdraw();
					break;
				case 4:
                    currentUser.pinChange();
                    break;
                case 5:
                    currentUser.exit();
                    System.exit(0);
                    break;
				default:
					System.out.println("Enter correct Choice..");
				}
				System.out.println("Do you want to continue(Y/N):");
				status = sc.next();
			} while (status.equalsIgnoreCase("Y"));
		} else {
			System.out.println("Account No. OR Pin Doesn't match...");
		}

	}

}
