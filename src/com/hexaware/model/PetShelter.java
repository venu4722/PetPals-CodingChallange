package com.hexaware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.util.DBConnection;

public class PetShelter {
	public void addPet(Pet pet) {
		try {
			Connection connection=DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into pet values(?,?,?,?)");
			preparedStatement.setInt(1, pet.getPetId());
			preparedStatement.setString(2, pet.getName());
			preparedStatement.setInt(3, pet.getAge());
			preparedStatement.setString(4, pet.getBreed());
			int k=preparedStatement.executeUpdate();
			if(k>0) {
				System.out.println("Pet added successfully..");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removePet(int petId) {
		try {
			Connection connection =DBConnection.getCon();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from pet where petid=?");
			preparedStatement.setInt(1, petId);
			int k=preparedStatement.executeUpdate();
			if(k>0) {
				System.out.println("Pet removed Successfullyy..");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Pet> getAvailablePets() {
        List<Pet> availablePets = new ArrayList<>();
        try {
        	Connection connection=DBConnection.getCon();
        	Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pet");
            while (resultSet.next()) {
                int id = resultSet.getInt("petid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String breed = resultSet.getString("breed");
                availablePets.add(new Pet(id, name, age, breed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availablePets;
    }
}
