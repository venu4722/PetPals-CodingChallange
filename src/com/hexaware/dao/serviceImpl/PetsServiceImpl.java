package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.service.PetsService;
import com.hexaware.util.DBConnection;

public class PetsServiceImpl implements PetsService{

	@Override
	public void displayPets() {
		try {
			Connection connection=DBConnection.getCon();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from pet");
			while(resultSet.next()) {
				System.out.println("PetId:" + resultSet.getInt(1));
				System.out.println("PetName: "+ resultSet.getString(2));
				System.out.println("PetAge:"+ resultSet.getInt(3));
				System.out.println("PetBreed:"+ resultSet.getString(4));
				System.out.println("---------------------------------");
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
