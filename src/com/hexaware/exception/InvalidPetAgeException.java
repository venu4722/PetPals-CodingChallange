package com.hexaware.exception;

@SuppressWarnings("serial")
public class InvalidPetAgeException extends Exception{
	public InvalidPetAgeException(String msg) {
		super(msg);
	}
}
