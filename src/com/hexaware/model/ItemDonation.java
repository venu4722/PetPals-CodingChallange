package com.hexaware.model;

import com.hexaware.controller.DonationController;


public class ItemDonation extends Donation{
	private String itemType;
	
	
	 public ItemDonation(String donorName, double amount, String itemType) {
	        super(donorName, amount);
	        this.itemType = itemType;
	    }
	 
	 

	public String getItemType() {
		return itemType;
	}



	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	DonationController daCntroller=new DonationController();
	@Override
	public void recordDonation() {
		daCntroller.recordItemDonation();
		
	}

}
