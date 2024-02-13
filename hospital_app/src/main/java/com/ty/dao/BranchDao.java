package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Address;
import com.ty.dto.Branch;
import com.ty.dto.Hospital;

//class which performs actions on branch.
public class BranchDao {
	static Scanner scan=new Scanner(System.in); 
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//method which saves the branch details to particular hospital
	public Branch saveBranch(Branch branch) {
		
		//finding the hospital 
		System.out.println("Enter the hospital Id to save the branch");
		String user_hospital_id=scan.next();
		Hospital hospital_find=entityManager.find(Hospital.class, user_hospital_id);
		
		//Entering the details of branch to get added to the hospital by checking
		//the hospital exist or not
		if(hospital_find!=null) {
		System.out.println("Enter the Branch Id");
		String user_branch_id=scan.next();
		branch.setBranchId(user_branch_id);
		System.out.println("Enter the Branch Name");
		String user_branch_name=scan.next();
		branch.setBranchName(user_branch_name);
		System.out.println("Enter the Branch Manager");
		String user_branch_manager=scan.next();
		branch.setBranchManager(user_branch_manager);
		System.out.println("Enter the Branch Contact");
		String user_branch_contact=scan.next();
		branch.setBranchContact(user_branch_contact);
		System.out.println("Enter the number of beds");
		int user_numberOfBeds=scan.nextInt();
		branch.setNumberOfBeds(user_numberOfBeds);
		
		System.out.println("Enter the Branch Address Details");
			Address address_details=AddressDao.saveAddress(new Address());
			branch.setAddress(address_details);
			
			List<Branch> branches=hospital_find.getBranches();
			branches.add(branch);
			hospital_find.setBranches(branches);
			
			//saving branch details
			entityTransaction.begin();
			entityManager.persist(address_details);
			entityManager.persist(branch);
			entityTransaction.commit();
			
			//Updating hospital list
			entityTransaction.begin();
			entityManager.merge(hospital_find);
			entityTransaction.commit();
			
			return branch;
		}else {
			System.out.println("Not Possible to add the branch because entered hospital id does not exist");
		}
		return null;
		
	}

	//method fetches the branch details by id
	public boolean FindBranchById(String user_branch_id) {
		
		Branch branch_find=entityManager.find(Branch.class, user_branch_id);
		
		
		//fetching the branch details by validating the user input
		if(branch_find!=null) {
			
			System.out.println("-----Branch Details------");
			System.out.println("Branch Id is : "+branch_find.getBranchId());
			System.out.println("Branch Name is : "+branch_find.getBranchName());
			
			System.out.println("Branch Manager is : "+branch_find.getBranchManager());
			System.out.println("Branch Contact is : "+branch_find.getBranchContact());
			System.out.println("Branch Capacity : "+branch_find.getNumberOfBeds());
			System.out.println("Branch Address is : "+branch_find.getAddress().getCity()+","+branch_find.getAddress().getStreet()+","+branch_find.getAddress().getState()+"-"+branch_find.getAddress().getPinCode());
			
			return true;
		}else {
			System.out.println("Branch does not exist with specified Id");
		}
		
		return false;
		
	}

	

}
