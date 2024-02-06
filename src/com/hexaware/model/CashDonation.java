package com.hexaware.model;

import java.text.ParseException;
import java.util.Date;

import com.hexaware.controller.DonationController;


public class CashDonation extends Donation {
	private Date donationDate;
	
	
	public CashDonation(String donorName, double amount, Date donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }
	
	

	
	public Date getDonationDate() {
		return donationDate;
	}




	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}



	DonationController donationCntroller=new DonationController();
	@Override
	public void recordDonation() {
		try {
			donationCntroller.recordCashDonation();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
