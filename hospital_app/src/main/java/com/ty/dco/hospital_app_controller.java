package com.ty.dco;

import com.ty.dao.Management;
import com.ty.dao.ManagementEmployee;
import com.ty.dao.ManagementPatient;

public class hospital_app_controller {
	
	static boolean flag=true;
	static boolean flags=true;
	public static void main(String[] args) {
		
		while(true) {
		int choice=Management.selectChoice();
		switch(choice) {
		case 1:{
			while(flag) {
				int employee_choice=Management.selectEmployeeChoice();
				switch(employee_choice) {
				case 1:{
					ManagementEmployee.saveHospital();
				}break;
				case 2:{
					ManagementEmployee.saveBranch();
				}break;
				case 3:{
					ManagementEmployee.FindHospitalById();
				}break;
				case 4:{
					ManagementEmployee.FindBrachById();;
				}break;
				case 5:{
					flag = false;
				}break;
				default:System.out.println("Enter Valid Choice");
				}
			}
		}break;
		case 2:{
			while(flags) {
				int patient_Choice=Management.selectPatientChoice();
				switch(patient_Choice) {
				case 1:{
					ManagementPatient.saveEncounter();
				}break;
				case 2:{
					ManagementPatient.saveMedicalOrder();
				}break;
				case 3:{
					ManagementPatient.updateMedicalOrder();
				}break;
				case 4:{
					flags=false;
				}break;
				default:System.out.println("Enter valid choice");
				}
			}
		}break;
		case 3:{
			return;
		}
		default:System.out.println("Invalid choice");
		}
		}
		
	}

}
