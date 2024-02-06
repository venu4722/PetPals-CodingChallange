package com.hexaware.model;

public class Pet {
	private int petId;
	private String name;
	private int age;
	private String breed;
	
	public Pet() {}
	
	public Pet(int petId,String name, int age, String breed) {
		super();
		this.petId=petId;
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	
	
	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", breed=" + breed + "]";
	}
	
	
	
	
}
