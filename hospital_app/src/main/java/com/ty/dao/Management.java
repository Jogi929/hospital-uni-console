package com.ty.dao;

import java.util.Scanner;

public class Management {
	
	
	//scanner  class to receive user's choice
	static Scanner scan=new Scanner(System.in);
	
	
	//static method to select the user choice with respect to employee or patient
	public static int selectChoice() {
		System.out.println("1.For Employee");
		System.out.println("2.For Patient");
		System.out.println("3.Exit");
		
		System.out.println("Enter the choice");
		int choice=scan.nextInt();
		return choice;
	}


	public static int selectEmployeeChoice() {
		System.out.println("1.Save Hospital");
		System.out.println("2.Save Branch");
		System.out.println("3.Find Hospital by id");
		System.out.println("4.Find Branch by id");
		System.out.println("5.Exit");
		
		System.out.println("Enter the employee choice");
		int choice=scan.nextInt();
		return choice;
	}
	
	public static int selectPatientChoice() {
		System.out.println("1.Save Encounter");
		System.out.println("2.Save MedicalOrders");
		System.out.println("3.Update Medical Order");
		System.out.println("4.Exit");
		
		System.out.println("Enter the Patient choice");
		int choice=scan.nextInt();
		return choice;
	}
}
