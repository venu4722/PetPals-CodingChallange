package com.hexaware.dao.service;

import com.hexaware.model.CashDonation;
import com.hexaware.model.Donation;
import com.hexaware.model.ItemDonation;

public interface IDonationService {
	void insertDonationRecord(Donation donation);
	void recordCashDonation(CashDonation donation);
	void recordItemDonation(ItemDonation donation);
}
