package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.service.IAdoptable;
import com.hexaware.model.*;

import com.hexaware.util.DBConnection;


public class AdoptionServiceImpl implements IAdoptable{
	ParticipantsServiceImpl participantsServiceImpl=new ParticipantsServiceImpl();
	@Override
	public void Participants() {
		try {
			Connection connection=DBConnection.getCon();
			Statement preparedStatement=connection.createStatement();
			ResultSet resultSet=preparedStatement.executeQuery("select participantid,participantname,participantemail from participants");
			while(resultSet.next()) {
				System.out.println("participantid:"+ resultSet.getInt(1));
				System.out.println("participantname:"+resultSet.getString(2));
				System.out.println("participantemail:"+ resultSet.getString(3));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void registerParticipant(Participants participants){
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement pStatement=connection.prepareStatement("insert into participants values(?,?,?,?)");
			pStatement.setInt(1, participants.getId());
			pStatement.setObject(2, participants.getAdoptionEvents().getEventId());
			pStatement.setString(3, participants.getParticipantName());
			pStatement.setString(4, participants.getParticipantEmail());
			int k=pStatement.executeUpdate();
			if(k>0) {
				System.out.println("Participant Registered Sucessfully..");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void hostAdoptionEvent(AdoptionEvents adoptionEvents) {
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into adoptionevents values(?,?,?)");
			preparedStatement.setInt(1, adoptionEvents.getEventId());
			preparedStatement.setString(2, adoptionEvents.getEventName());
			preparedStatement.setDate(3,  new java.sql.Date(adoptionEvents.getEventDate().getTime()));
			int k=preparedStatement.executeUpdate();
			if(k>0) {
				System.out.println("Adoption Event hosted Successully...");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public AdoptionEvents getEventById(int id) {
		AdoptionEvents adoptionEvents=null;
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement pStatement=connection.prepareStatement("select * from adoptionevents where eventid=?");
			pStatement.setInt(1, id);
			ResultSet resultSet=pStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("AdoptionEventId:"+ resultSet.getInt(1));
				System.out.println("AdoptionEventName:"+ resultSet.getString(2));
				System.out.println("AdoptionEventDate:"+ resultSet.getDate(3));
				adoptionEvents=new AdoptionEvents(resultSet.getInt(1),resultSet.getString(2),resultSet.getDate(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptionEvents;
		
	}

	@Override
	public void adopt() {
		participantsServiceImpl.getEventById(1);
		
	}
}
