package com.ty.dao;

import java.util.Scanner;

import com.ty.dto.Person;

public class PersonDao {
	static Scanner scan=new Scanner(System.in); 

	public static Person savePerson(Person person) {
		
		System.out.println("Enter Person Id");
		String person_id=scan.next();
		person.setPersonId(person_id);
		System.out.println("Enter the FirstName");
		String person_first_name=scan.next();
		person.setFirstName(person_first_name);
		System.out.println("Enter the Last Name");
		String person_last_name=scan.next();
		person.setLastName(person_last_name);
		System.out.println("Enter the contact Number");
		String person_contact_number=scan.next();
		person.setContact(person_contact_number);
		System.out.println("Enter the Gender");
		String gender=scan.next();
		person.setGender(gender);
		
		return person;
		
	}
	
	
	

}
