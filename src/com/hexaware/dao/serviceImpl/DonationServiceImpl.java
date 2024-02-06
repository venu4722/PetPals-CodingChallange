package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.dao.service.IDonationService;
import com.hexaware.model.CashDonation;
import com.hexaware.model.Donation;
import com.hexaware.model.ItemDonation;
import com.hexaware.util.DBConnection;

public class DonationServiceImpl implements IDonationService{

	@Override
	public void insertDonationRecord(Donation donation) {
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("Insert into donation values(?,?)");
			preparedStatement.setString(1, donation.getDonarName());
			preparedStatement.setDouble(2, donation.getAmount());
			int k=preparedStatement.executeUpdate();
			if(k>0) {
				System.out.println("Donation record updated successfully...");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void recordCashDonation(CashDonation cashDonation) {
		try {
			Connection connection =DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into cashdonation values(?,?,?)");
			preparedStatement.setString(1, cashDonation.getDonarName());
			preparedStatement.setDouble(2, cashDonation.getAmount());
			preparedStatement.setDate(3, new java.sql.Date(cashDonation.getDonationDate().getTime()));
			int k=preparedStatement.executeUpdate();
			if(k>0)System.out.println("cash donated  successfully..");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void recordItemDonation(ItemDonation itemDonation) {
		try {
			Connection connection =DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into itemdonation values(?,?,?)");
			preparedStatement.setString(1, itemDonation.getDonarName());
			preparedStatement.setDouble(2, itemDonation.getAmount());
			preparedStatement.setString(3, itemDonation.getItemType());
			int k=preparedStatement.executeUpdate();
			if(k>0)System.out.println("cash and (food or toy) donated successfully..");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
