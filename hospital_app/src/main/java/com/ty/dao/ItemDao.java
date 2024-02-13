package com.ty.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Item;

public class ItemDao {
	
	static Scanner scan=new Scanner(System.in); 
	static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public static Item saveItem(Item item) {
		
		System.out.println("Enter the Item Id ");
		String itemId=scan.next();
		item.setItemId(itemId);
		
		System.out.println("Enter the item name");
		String item_name=scan.next();
		item.setItemName(item_name);
		
		System.out.println("Enter the item quantity");
		int item_quantity=scan.nextInt();
		item.setQuantity(item_quantity);
		
		System.out.println("Enter the Price");
		double price=scan.nextDouble();
		item.setUnitPrice(price);
		
		System.out.println("Enter the Supplier name");
		String supplier=scan.next();
		item.setSupplier(supplier);
		
		//saving into database
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		
		return item;
	}
	
	

}
