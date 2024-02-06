package com.hexaware.model;

public class Cat extends Pet{
	private String catColor;
	
	public Cat() {}

	public Cat(String catColor) {
		super();
		this.catColor = catColor;
	}

	public String getCatColor() {
		return catColor;
	}

	public void setCatColor(String catColor) {
		this.catColor = catColor;
	}
	
	
}
