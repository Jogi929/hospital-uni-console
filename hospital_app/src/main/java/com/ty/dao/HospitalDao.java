package com.ty.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Hospital;

public class HospitalDao {
	static Scanner scan=new Scanner(System.in); 
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//Method which saves the hospital details into database
	public Hospital saveHospital(Hospital hospital) {
		
		//Enter the hospital details
		System.out.println("Enter the Hospital id ");
		String user_hospitalId=scan.next();
		hospital.setHospitalId(user_hospitalId);
		System.out.println("Enter the Hospiital name");
		String user_hospitalName=scan.next();
		hospital.setHospitalName(user_hospitalName);
		System.out.println("Enter the Hospital Type");
		String user_hospitalType=scan.next();
		hospital.setHospitalType(user_hospitalType);
		System.out.println("Enter the Hospital Accredation");
		String user_hospitalAccredation=scan.next();
		hospital.setAccreditation(user_hospitalAccredation);
		System.out.println("Enter the Hospital Founding year");
		int user_founding_year=scan.nextInt();
		hospital.setFoundingYear(user_founding_year);
		
		//Saving the hospital details into database 
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		
		System.out.println("Hospital details added to the database successfully....");
		
		return hospital;
		
	}
	
	
	//method fetches the hospital details
	public boolean FindHospitalById(String user_hospital_id) {
		
		Hospital hospital_find=entityManager.find(Hospital.class, user_hospital_id);
		
		
		
		//fetching the entered hospital id details by validating the user input
		if(hospital_find!=null) {
			System.out.println("---------------Hospital Details----------");
			System.out.println("Hospital Id is : "+hospital_find.getHospitalId());
			System.out.println("Hospital Name is : "+hospital_find.getHospitalName());
			System.out.println("Hospital Type is : "+hospital_find.getHospitalType());
			System.out.println("Hospital Accreditation is : "+hospital_find.getAccreditation());
			System.out.println("Hospital Established Year is : "+hospital_find.getFoundingYear());
			System.out.println("Number of Branches Under the Hospital : "+hospital_find.getBranches().size());
			
			return true;
		}else {
			System.out.println("Entered Hospital Id does not exist");
		}
		
		return false;
		
	}

}
