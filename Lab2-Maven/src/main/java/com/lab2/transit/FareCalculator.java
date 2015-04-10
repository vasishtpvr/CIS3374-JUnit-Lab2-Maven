package com.lab2.transit;

import java.util.Scanner;

public class FareCalculator {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("Welcome to the Fare Calculator Program!");
		
		while(true) {
			scanner = new Scanner(System.in);
			System.out.print("Please enter the age (-1 to quit): ");
			int age = scanner.nextInt();
			if(age == -1) {
				break;
			}
			System.out.print("Please enter the time: ");
			String time = scanner.next();
			System.out.print("Is today a holiday (True or False)?");
			boolean isHoliday = scanner.nextBoolean();
			System.out.println("Your fare is: " + calculateFare(age, time, isHoliday));
		}

	}
	
	/**
	 * 
	 * @param age - The age of the person
	 * @param time - The time in military (24-hour) format e.g. 4:00 PM would be 16:00 
	 * @param isHoliday - If the day is a holiday or not
	 * @return - 0.0 if discounted fare, 2.5 if regular fare
	 */
	public static double calculateFare(int age, String time, boolean isHoliday) {
		
		String[] parsedTime = time.split(":");
		
		int hour = Integer.parseInt(parsedTime[0]);
		int minutes = Integer.parseInt(parsedTime[1]);
		
		if(age <= 5 || age >= 65) {	
			if(hour < 7 || (hour == 9 && minutes > 0) || hour > 9 || isHoliday) {
				return 0.0;
			}
		}
		
		return 2.5;
	}

}
