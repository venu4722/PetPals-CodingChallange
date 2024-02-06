package com.hexaware.main;

import java.text.ParseException;
import java.util.Scanner;

import com.hexaware.controller.AdoptionEventController;


public class AdoptionEventView {
	Scanner scanner=new Scanner(System.in);
	AdoptionEventController adoptionEventController=new AdoptionEventController();
	public void displayAdoption() throws ParseException {
		String string=null;
		do {
			System.out.println("1. Register Participant");
			System.out.println("2. Host AdoptionEvent");
			System.out.println("Enter your choice:");
			int ch=scanner.nextInt();
			switch (ch) {
			case 1:{
				adoptionEventController.registerParticipant();
				break;
			}
			case 2:{
				adoptionEventController.hostAdoptionEvent();
				break;
			}
			default:
				System.out.println("Invalid choice...");
				break;
			}
			System.out.println("Do you want to continue.. Type-y");
			string=scanner.next();
		}while(string.equalsIgnoreCase("y"));
}}
