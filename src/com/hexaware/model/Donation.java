package com.hexaware.model;

public abstract class Donation {
	private String donarName;
	private double amount;
	
	public Donation(String donarName, double amount) {
		super();
		this.donarName = donarName;
		this.amount = amount;
	}
	
	public abstract void recordDonation();

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
