package com;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StudentManagementSystem sms = new StudentManagementSystemImplementation();
		
		System.out.println("Welcome to Student Database Management System");
		System.out.println("=============================================");
		
		while(true) {
			
			System.out.println("1:Add Student\n2:Update Student");
			System.out.println("3:Delete Student\n4:Delete All Students");
			System.out.println("5:Display Student\n6:Display All Students");
			System.out.println("7:Sort Students\n8:Exit");
			
			System.out.println("Enter Your Choice");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.println("Adding Students");
				sms.addStudent();
				break;
			case 2: 
				System.out.println("Update Students");
				sms.updateStudent();
				break;
			case 3:
				System.out.println("Delete Students");
				sms.deleteStudent();
				break;
			case 4:
				System.out.println("Delete All Students");
				sms.deleteAllStudent();
				break;
			case 5:
				System.out.println("Display Students");
				sms.displayStudent();
				break;
			case 6:
				System.out.println("Display All Students");
				sms.displayAllStudent();
				break;
			case 7:
				System.out.println("Sort Students");
				sms.sortStudent();
				break;
			case 8:
				System.out.println("THANK yOU!!!!!");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("=======================================");
			
		}
		
	}
	
}
