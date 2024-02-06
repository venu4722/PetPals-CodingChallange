package com.hexaware.main;

import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws ParseException {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String string=null;
		DonationView donationView=new DonationView();
		PetsView petsView=new PetsView();
		AdoptionEventView adoptionEventView=new AdoptionEventView();
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("---Petpals (The Pet Adoption Platform)---");
		System.out.println("----------------------------------------");
		System.out.println("-----------------------------------------");
		do {
			System.out.println("1. Pets Page..");
			System.out.println("2. Donation Page..");
			System.out.println("3. Adoption Event Page..");
			System.out.println("Enter Your Choice:");
			int ch=scanner.nextInt();
			switch (ch) {
			case 1:{
				petsView.displayPets();
				break;
			}
			case 2:{
				donationView.displayDonation();
				break;
			}
			case 3:{
				adoptionEventView.displayAdoption();
				break;
			}
			default:
				System.out.println("Invalid choice.");
				break;
			}
			System.out.println("Do you want to continue our Page.Type-y");
			string=scanner.next();
		}while(string.equalsIgnoreCase("y"));
			System.out.println("----------Thank you for using our system..-------------");
		System.exit(0);
		
	}
}
