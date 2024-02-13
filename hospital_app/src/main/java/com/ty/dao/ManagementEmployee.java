package com.ty.dao;

import java.util.Scanner;

import com.ty.dto.Branch;
import com.ty.dto.Hospital;

//Helper class which provides functionality of the Employee actions
public class ManagementEmployee {
static HospitalDao hospitalDao=new HospitalDao();
static BranchDao branchDao=new BranchDao();
static Scanner scan=new Scanner(System.in); 
	
	
	public static void saveHospital() {
		hospitalDao.saveHospital(new Hospital());
	}


	public static void saveBranch() {
		branchDao.saveBranch(new Branch());
	}

	public static void FindHospitalById() {
		
		System.out.println("Enter the Hospital id");
		String user_hospital_id=scan.next();
		hospitalDao.FindHospitalById(user_hospital_id);
	}

	public static void FindBrachById() {
		
		System.out.println("Enter the Branch id");
		String user_branch_id=scan.next();
		branchDao.FindBranchById(user_branch_id);
	}


	
	
	

}
