package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.PetsController;


public class PetsView {
	Scanner scanner=new Scanner(System.in);
	PetsController petsController=new PetsController();
	public void displayPets() {
		String string=null;
		do {
			System.out.println("1. Add a Pet");
			System.out.println("2. Delete a Pet");
			System.out.println("3. All the available pets");
			System.out.println("4. List of All Pets using Collections");
			System.out.println("Enter your choice:");
			int ch=scanner.nextInt();
			switch (ch) {
			case 1:{
				petsController.addPets();
				break;
			}
			case 2:{
				petsController.removePet();
				break;
			}
			case 3:{
				petsController.listAllPets();;
				break;
			}
			case 4:{
				 System.out.println(petsController.listAllPetsUsingCollections());
				break;
			}

			default:
				System.out.println("Invalid choice...");
				break;
			}
			System.out.println("Do you want to continue.. Type-y");
			string=scanner.next();
		}while(string.equalsIgnoreCase("y"));
		
	}
}
