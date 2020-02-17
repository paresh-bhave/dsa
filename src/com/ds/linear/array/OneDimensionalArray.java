package com.ds.linear.array;

public class OneDimensionalArray {
	public static void main(String[] args) {
		// int array
		int numbers[] = new int[5];
		
		numbers[0] = 11;
		numbers[1] = 12;
		numbers[2] = 13;
		numbers[3] = 14;
		numbers[4] = 15;
		
		// array of strings
		String vowels[] = {"a","e","i","o","u"};
		
		// accessing above arrays with for loop
		for (int i = 0; i < 5; i++) {
			System.out.println("numbers[" + i + "] = " + numbers[i]);
			System.out.println("vowels[" + i + "] = " + vowels[i]);
		}
		
		//array of user defined type (class)
		Student students[] = new Student[3];
		
		students[0] = new Student(0, "John");
		students[1] = new Student(1, "Jake");
		students[2] = new Student(2, "Joey");
		
		// accessing objects on particular index
		students[0].printDetails();
		students[1].printDetails();
		students[2].printDetails();
	}
}
