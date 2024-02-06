package com.hexaware.controller;

import java.text.ParseException;

import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.serviceImpl.DonationServiceImpl;
import com.hexaware.exception.InsufficientException;
import com.hexaware.model.CashDonation;
import com.hexaware.model.ItemDonation;


public class DonationController {
	Scanner scanner=new Scanner(System.in);
	DonationServiceImpl donationServiceImplDao=new DonationServiceImpl();
	
	public void recordCashDonation() throws ParseException {
		System.out.println("Enter Donar Name:");
		String donarName=scanner.nextLine();
		System.out.println("Enter Amount:");
		Double amount=scanner.nextDouble();
		boolean validAmount = false;
		while (!validAmount) {
			try {
				if (amount<100) {
					throw new InsufficientException("Donation should be minimum 100");
				}
				validAmount = true;
			} catch (InsufficientException ine) {
				ine.getMessage();
				System.out.println("Invalid Amount. Please enter a valid amount:");
				amount = scanner.nextDouble();
			}
		}
		Date date=new Date();
        CashDonation cashDonation=new CashDonation(donarName, amount, date);
        donationServiceImplDao.recordCashDonation(cashDonation);
        
	}
	
	public void recordItemDonation() {
		System.out.println("Enter Donar Name:");
		String donarName=scanner.nextLine();
		System.out.println("Enter Amount:");
		Double amount=scanner.nextDouble();
		boolean validAmount = false;
		while (!validAmount) {
			try {
				if (amount<100) {
					throw new InsufficientException("Donation should be minimum 100");
				}
				validAmount = true;
			} catch (InsufficientException ine) {
				ine.getMessage();
				System.out.println("Invalid Amount. Please enter a valid amount:");
				amount = scanner.nextDouble();
			}
		}
		scanner.nextLine();
		System.out.println("Enter Item(food or toys)");
		String item=scanner.next();
        ItemDonation itemDonation=new ItemDonation(donarName, amount, item);
        donationServiceImplDao.recordItemDonation(itemDonation);
        
	}
	
	
	
}
