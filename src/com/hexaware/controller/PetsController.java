package com.hexaware.controller;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.serviceImpl.PetsServiceImpl;
import com.hexaware.exception.InvalidPetAgeException;
import com.hexaware.model.Pet;
import com.hexaware.model.PetShelter;

public class PetsController {
	Scanner scanner=new Scanner(System.in);
	PetShelter pShelter=new PetShelter();
	PetsServiceImpl petsServiceImpl=new PetsServiceImpl();
	public void addPets() {
		System.out.println("Enter the Pet Id:");
		int petId=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Pet name:");
		String petName=scanner.nextLine();
		System.out.println("Enter the pet age:");
		int petAge=scanner.nextInt();
		boolean validEmailEntered = false;
		while (!validEmailEntered) {
			try {
				if (petAge<0) {
					throw new InvalidPetAgeException("PetAge should be a positive Integer");
				}
				validEmailEntered = true;
			} catch (InvalidPetAgeException ine) {
				ine.getMessage();
				System.out.println("Invalid Age. Please enter a valid email:");
				petAge = scanner.nextInt();
			}
		}
		scanner.nextLine();
		System.out.println("Enter the pet Breed:");
		String breed=scanner.nextLine();
		Pet pet=new Pet(petId,petName,petAge,breed);
		pShelter.addPet(pet);

	}
	public void removePet() {
		System.out.println("Enter the petId:");
		int petId=scanner.nextInt();
		pShelter.removePet(petId);
	}
	public void listAllPets() {
		petsServiceImpl.displayPets();
	}
	public List<Pet> listAllPetsUsingCollections() {
		return pShelter.getAvailablePets();
	}
	
}
