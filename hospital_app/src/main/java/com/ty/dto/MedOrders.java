
package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MedOrders {
	
	@Id
	private String orderId;
    private String  payment_mode;
    private String delivery_satus;
    private String prescriptionStatus;
    private String pharmacy_name;
    
    @ManyToMany
    private List<Item> items;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getDelivery_satus() {
		return delivery_satus;
	}

	public void setDelivery_satus(String delivery_satus) {
		this.delivery_satus = delivery_satus;
	}

	public String getPrescriptionStatus() {
		return prescriptionStatus;
	}

	public void setPrescriptionStatus(String prescriptionStatus) {
		this.prescriptionStatus = prescriptionStatus;
	}

	public String getPharmacy_name() {
		return pharmacy_name;
	}

	public void setPharmacy_name(String pharmacy_name) {
		this.pharmacy_name = pharmacy_name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
    
    
}
