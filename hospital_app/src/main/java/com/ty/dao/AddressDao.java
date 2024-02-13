package com.ty.dao;

import java.util.Scanner;

import com.ty.dto.Address;

public class AddressDao {
	static Scanner scan=new Scanner(System.in); 

	public static Address saveAddress(Address address) {
		
		System.out.println("Enter the Address_id");
		String user_address_id=scan.next();
		address.setAddress_id(user_address_id);
		System.out.println("Enter the City");
		String user_city=scan.next();
		address.setCity(user_city);
		System.out.println("Enter the Street");
		String user_street=scan.next();
		address.setStreet(user_street);
		System.out.println("Enter the state");
		address.setState(scan.next());
		System.out.println("Enter the pincode");
		String user_pincode=scan.next();
		address.setPinCode(user_pincode);
		
		return address;
	}

}
