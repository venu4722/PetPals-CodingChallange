package com.hexaware.model;

public class Dog extends Pet{
	private String dogBreed;

	public Dog() {}
	
	public Dog(String dogBreed) {
		super();
		this.dogBreed = dogBreed;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	
	
	
	
	
}
