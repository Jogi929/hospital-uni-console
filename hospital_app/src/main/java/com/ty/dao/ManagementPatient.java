package com.ty.dao;

import java.util.Scanner;

import com.ty.dto.Encounter;
import com.ty.dto.MedOrders;

public class ManagementPatient {

	static EncounterDao encounterDao=new EncounterDao();
	static MedOrdersDao medorderDao=new MedOrdersDao();
	static Scanner scan=new Scanner(System.in); 
	
	public static void saveEncounter() {
		System.out.println("Enter the Branch Id");
		String branch_id=scan.next();
		encounterDao.saveEncounter(branch_id,new Encounter());
	}

	public static void saveMedicalOrder() {
		System.out.println("Enter the Encounter Id");
		String encounterId=scan.next();
		medorderDao.saveMedicalOrder(encounterId,new MedOrders());
		
	}

	public static void updateMedicalOrder() {
		System.out.println("Enter the Medical order Id");
		String medicalOrderId=scan.next();
		medorderDao.updateMedicalOrder(medicalOrderId);
		
	}

	
	
	
	
	

}
