package com.ty.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Person;

public class EncounterDao {
	
	
	static Scanner scan=new Scanner(System.in); 
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction=entityManager.getTransaction();

		public Encounter saveEncounter(String branch_id, Encounter encounter) {
			
			Branch branch=entityManager.find(Branch.class, branch_id);
			
			if(branch!=null) {
				System.out.println("Select any choice");
				System.out.println("1.New User");
				System.out.println("2.Existing User");
				int encounter_choice=scan.nextInt();
			switch(encounter_choice) {
			case 1:{
				
				//taking person details
				Person person=PersonDao.savePerson(new Person());
				encounter.setPerson(person);
				//taking encounter details
				System.out.println("Enter the Encounter id");
				String user_encounter_id=scan.next();
				encounter.setEncounterId(user_encounter_id);
				System.out.println("Enter the Blood Pressure satus");
				String user_blood_pressure=scan.next();
				encounter.setBlood_pressure(user_blood_pressure);
				System.out.println("Enter the body temeperature");
				String user_temperature=scan.next();
				encounter.setBody_temperature(user_temperature);
				System.out.println("Enter the diagnosis required");
				String user_daignosis=scan.next();
				encounter.setDiagnosis(user_daignosis);
				System.out.println("Enter the Doctor to be Consulted");
				String user_consult=scan.next();
				encounter.setDoctor_consulted(user_consult);
				
				//saving into database
				entityTransaction.begin();
				entityManager.persist(person);
				entityManager.persist(encounter);
				entityTransaction.commit();
				
				System.out.println("Appointment Booked");
			}break;
			case 2:{
				System.out.println("Enter the Person id");
				String user_person_id=scan.next();
				
				Person person=entityManager.find(Person.class, user_person_id);
				
				if(person!=null) {
					//taking encounter details
					System.out.println("Enter the Encounter id");
					String user_encounter_id=scan.next();
					encounter.setEncounterId(user_encounter_id);
					System.out.println("Enter the Blood Pressure satus");
					String user_blood_pressure=scan.next();
					encounter.setBlood_pressure(user_blood_pressure);
					System.out.println("Enter the body temeperature");
					String user_temperature=scan.next();
					encounter.setBody_temperature(user_temperature);
					System.out.println("Enter the diagnosis required");
					String user_daignosis=scan.next();
					encounter.setDiagnosis(user_daignosis);
					System.out.println("Enter the Doctor to be Consulted");
					String user_consult=scan.next();
					encounter.setDoctor_consulted(user_consult);
					
					encounter.setPerson(person);
					
					//saving into database
					entityTransaction.begin();
					entityManager.persist(encounter);
					entityTransaction.commit();
					
					System.out.println("Appointment Booked");
					
				}else {
					System.out.println("Entered Person Id does not exist");
				}
			}break;
			default: System.out.println("Enter valid choice");
			}
		}else {
			System.out.println("Branch does not exist");
		}
		
		return encounter;
		
	}

}
