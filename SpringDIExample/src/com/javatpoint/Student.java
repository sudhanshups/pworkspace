package com.javatpoint;

import java.util.List;

public class Student {
	private List<Subject> subjects;
	private int roll;
	private String name;
	
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Student(){
		
	}
	public Student(int roll) {
		System.out.println("Inside constructor with roll number");
		this.roll = roll;
	}

	public Student(String name) {
		System.out.println("Inside constructor with name");
		this.name = name;
	}
	
	public Student(int roll, String name) {
		System.out.println("Inside constructor with name and roll");
		this.roll = roll;
		this.name = name;
	}

	public Student(String name, int roll, List<Subject> subjects) {
		System.out.println("Inside constructor");
		this.name = name;
		this.roll = roll;
		this.subjects = subjects;
	}


	public void displayInfo() {
		System.out.println("Hello: " + name);
	}
	public void displayName() {
		System.out.println("Name: " + name);
	}
	public void displayRoll() {
		System.out.println("Roll: " + roll);
	}
	public void displaySubjects() {
		if(subjects != null){
			System.out.println("Below are the subject list");
			for (Subject subject : subjects) {
				System.out.println(subject.getSubject());
			}
		}else{
			System.out.println("Student has no subjects");
		}
	}
	public void display() {
		System.out.println("==============================");
		displayName();
		displayRoll();
		displaySubjects();
		System.out.println("==============================");
	}
	
}