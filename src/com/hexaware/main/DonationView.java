package com.hexaware.main;

import java.text.ParseException;
import java.util.Scanner;

import com.hexaware.controller.DonationController;

public class DonationView {
	Scanner scanner=new Scanner(System.in);
	DonationController donationCntroller=new DonationController();
	public void displayDonation() throws ParseException {
		String string=null;
		do {
			System.out.println("1.Donation of cash");
			System.out.println("2. Donation of item(Food or TOY) and Money");
			System.out.println("Enter your choice:");
			int ch=scanner.nextInt();
			switch (ch) {
			case 1:{
				donationCntroller.recordCashDonation();
				break;
			}
			case 2:{
				donationCntroller.recordItemDonation();
				break;
			}
		

			default:
				System.out.println("Invalid choice...");
				break;
			}
			System.out.println("Do you want to continue.. Type-y");
			string=scanner.next();
		}while(string.equalsIgnoreCase("y"));
		
}
}
