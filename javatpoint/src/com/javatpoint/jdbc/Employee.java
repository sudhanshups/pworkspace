package com.javatpoint.jdbc;

public class Employee {
	private int id;
	private String name;
	private float salary;

	public Employee() {
	}

	public Employee(int i, String string, float j) {
		id = i;
		name = string;
		salary = j;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return id + " " + name + " " + salary;
	}
}