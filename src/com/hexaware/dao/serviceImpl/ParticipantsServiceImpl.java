package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.model.AdoptionEvents;
import com.hexaware.util.DBConnection;

public class ParticipantsServiceImpl {
	
	public AdoptionEvents getEventById(int id) {
		AdoptionEvents adoptionEvents=null;
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement pStatement=connection.prepareStatement("select * from adoptionevents where eventid=?");
			pStatement.setInt(1, id);
			ResultSet resultSet=pStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDate(3));
				adoptionEvents=new AdoptionEvents(resultSet.getInt(1),resultSet.getString(2),resultSet.getDate(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptionEvents;
		
	}
}
