package com.ty.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Encounter;
import com.ty.dto.Item;
import com.ty.dto.MedOrders;

public class MedOrdersDao {
	
	static Scanner scan=new Scanner(System.in); 
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction=entityManager.getTransaction();
	static boolean flag=true;

	
	public MedOrders saveMedicalOrder(String user_encounterId, MedOrders medOrders) {
		
		Encounter encounter_find=entityManager.find(Encounter.class, user_encounterId);
		
		if(encounter_find!=null) {
			System.out.println("Enter the orderId");
			String user_order_id=scan.next();
			medOrders.setOrderId(user_order_id);
			
			System.out.println("Enter the Payment Mode");
			String user_payment=scan.next();
			medOrders.setPayment_mode(user_payment);
			
			System.out.println("Enter the Delivery Status");
			String user_delivery=scan.next();
			medOrders.setDelivery_satus(user_delivery);
			
			System.out.println("Enter the Pharmacy Name");
			String user_pharmacy=scan.next();
			medOrders.setPharmacy_name(user_pharmacy);
			
			System.out.println("Enter one choice to add items");
			List<Item> items=new ArrayList<Item>();
			while(flag) {
				System.out.println("1.Add Item to Medical Order");
				System.out.println("2.Exit");
				int item_choice=scan.nextInt();
				
				switch(item_choice) {
				case 1:{
					Item item=ItemDao.saveItem(new Item());
					items.add(item);
				}break;
				case 2:{
					flag=false;
				}
				default: System.out.println("Invalid choice");
				}
			}
			medOrders.setItems(items);
			
			System.out.println("Enter the Prescription Status");
			String perscription_status=scan.next();
			medOrders.setPrescriptionStatus(perscription_status);
			
			List<MedOrders> orderList=encounter_find.getMedOrders();
			orderList.add(medOrders);
			encounter_find.setMedOrders(orderList);
			//saving into database
			entityTransaction.begin();
			entityManager.persist(medOrders);
			entityTransaction.commit();
			
			
			//updating the Encounter
			entityTransaction.begin();
			entityManager.merge(encounter_find);
			entityTransaction.commit();
			
			System.out.println("Saving Medical Order");
			return medOrders;
		}else {
			System.out.println("Prescription is Mandatory");
		}
		
		return null;
	}


	public boolean updateMedicalOrder(String medicalOrderId) {
		
		MedOrders medOrder=entityManager.find(MedOrders.class, medicalOrderId);
		
		if(medOrder!=null) {
			System.out.println("Enter one choice to add items");
			List<Item> items=medOrder.getItems();
			while(flag) {
				System.out.println("1.Add Item to Medical Order");
				System.out.println("2.Exit");
				int item_choice=scan.nextInt();
				
				switch(item_choice) {
				case 1:{
					Item item=ItemDao.saveItem(new Item());
					items.add(item);
				}break;
				case 2:{
					flag=false;
				}
				default: System.out.println("Invalid choice");
				}
			}
			medOrder.setItems(items);
			
			//updating the medrorder
			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
			
			System.out.println("Medical Order is updated");
			
			return true;
		}else {
			System.out.println("Medical Order does not exist");
		}
		return false;
	}

}
