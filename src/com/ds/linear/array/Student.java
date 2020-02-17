package com.ds.linear.array;

public class Student {
	int id;
	String name;
	
	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	void printDetails() {
		System.out.println("ID: " + id + " | NAME: " + name);
	}
}
