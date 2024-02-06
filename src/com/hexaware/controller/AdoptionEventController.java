package com.hexaware.controller;

import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.serviceImpl.AdoptionServiceImpl;
import com.hexaware.exception.AdoptionException;
import com.hexaware.model.AdoptionEvents;
import com.hexaware.model.Participants;

public class AdoptionEventController {
	AdoptionServiceImpl daoAdoptionServiceImpl=new AdoptionServiceImpl();
	Scanner scanner=new Scanner(System.in);
	
	public void registerParticipant() {
		System.out.println("Enter the participant id:");
		int id=scanner.nextInt();
		System.out.println("Enter the adoptionEventid:");
		int adoptionEventId=scanner.nextInt();
		AdoptionEvents adoptionEvents=daoAdoptionServiceImpl.getEventById(adoptionEventId);
		boolean adoptionid = false;
		while (!adoptionid) {
		    try {
		        if (adoptionEvents == null) {
		            throw new AdoptionException("The event you are looking is not present. please check");
		        }
		        adoptionid = true; 
		    } catch (AdoptionException re) {
		        System.out.println(re.getMessage());
		        System.out.println("Enter AdoptionEventId:");
		        adoptionEventId = scanner.nextInt();
		        adoptionEvents=daoAdoptionServiceImpl.getEventById(adoptionEventId);
		    }
		}
		scanner.nextLine();
		System.out.println("Enter Participant name:");
		String name=scanner.nextLine();
		System.out.println("Enter the participant mail:");
		String mail=scanner.nextLine();
		Participants participants=new Participants(id,adoptionEvents,name,mail);
		daoAdoptionServiceImpl.registerParticipant(participants);	
	}
	
	public void hostAdoptionEvent() {
		System.out.println("Enter the AdoptionEventId:");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Adoption Event Name:");
		String name=scanner.nextLine();
		Date date=new Date();
		AdoptionEvents adoptionEvents=new AdoptionEvents(id,name,date);
		daoAdoptionServiceImpl.hostAdoptionEvent(adoptionEvents);	
	}
}
