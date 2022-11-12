package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImplementation
	implements StudentManagementSystem
{
	Scanner scan = new Scanner(System.in);
	
	HashMap<String, Student> hm = new HashMap<String, Student>();

	@Override
	public void addStudent() {
		
		System.out.println("Enter Id, Name, Age, Marks");
		String id = scan.next();
		String name = scan.next();
		int age = scan.nextInt();
		int marks = scan.nextInt();
		
		Student std = new Student(id, name, age, marks);
		
		hm.put(std.getId(), std);
		
		System.out.println("Student Recorded Added Successfully");
		
	}

	@Override
	public void updateStudent() {
		
		System.out.println("Enter Student Id");
		String id = scan.next();
		
		if(hm.containsKey(id)) {
			
			Student std = hm.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter Name");
				String name = scan.next();
				std.setName(name);
				break;
			
			case 2:
				
				System.out.println("Enter Age");
				int age = scan.nextInt();
				std.setAge(age);
				break;
				
			case 3:
				
				System.out.println("Enter Marks");
				int marks = scan.nextInt();
				std.setMarks(marks);
				break;
				
			default: 
				System.out.println("Invalid Choice");
				
				
			}
			
		}else {
			System.out.println("Id is Invalid");
		}
		
	}

	@Override
	public void deleteStudent() {
		
		System.out.println("Enter Student id");
		String id = scan.next();
		
		if(hm.containsKey(id)) {
			System.out.println("Student Record Present");
			hm.remove(id);
			System.out.println("Student Record Deleted");
		}else {
			System.out.println("Student Record not Present");
		}
		
	}

	@Override
	public void deleteAllStudent() {
		
		hm.clear();
		System.out.println("All Student Records are Deleted");
		
	}

	@Override
	public void displayStudent() {
		
		System.out.println("Enter Student id");
		String id = scan.next();
		
		if(hm.containsKey(id)) {
			System.out.println("Student Record Available");
			
			Student std = hm.get(id);
			
			System.out.println("Student Details");
			System.out.println("Id : "+std.getId());
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("====================================");
			
			
//			System.out.println("");
		}else {
			System.out.println("Student Record Not Availabel");
		}
		
	}

	@Override
	public void displayAllStudent() {
		
		Set<String> s = hm.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext()) {
			String id = i.next();
			
			Student std = hm.get(id);
			
			System.out.println("Student Details");
			System.out.println("Id : "+std.getId());
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("====================================");
			
			
		}
	}

	@Override
	public void sortStudent() {
		
		ArrayList<Student> stu = new ArrayList<Student>();
		Set<String> s = hm.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext()) {
			String id = i.next();
			Student std = hm.get(id);
			stu.add(std);
		}
		
		System.out.println("Sort Student");
		System.out.println("1:By Id\n2:By Name\n3:By Age\n4:By Marks");
		System.out.println("Enter Choice");
		int choice = scan.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Sorting based on ID");
			Collections.sort(stu, new SortStudentById());
			for(Student s1 : stu)
			{
				System.out.println(s1);
			}
			break;

		case 2:
			System.out.println("Sorting based on NAME");
			Collections.sort(stu, new SortStudentByName());
			for(Student s1 : stu)
			{
				System.out.println(s1);
			}
			break;

		case 3:
			System.out.println("Sorting based on AGE");
			Collections.sort(stu, new SortStudentByAge());
			for(Student s1 : stu)
			{
				System.out.println(s1);
			}
			break;

		case 4:
			System.out.println("Sorting based on MARKS");
			Collections.sort(stu, new SortStudentByMarks());
			for(Student s1 : stu)
			{
				System.out.println(s1);
			}
			break;

		default:
			System.out.println("Invalid Choice");
		}
		
	}

}
