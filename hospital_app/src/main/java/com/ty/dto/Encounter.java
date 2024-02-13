package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity	
public class Encounter {
	
	@Id
	private String encounterId;
    private String blood_pressure;
    private String doctor_consulted;
    private String body_temperature;
    private String diagnosis;
    
    @ManyToOne
    private Person person;
    @OneToMany
    private List<MedOrders> medOrders;
	public String getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	
	public String getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public String getDoctor_consulted() {
		return doctor_consulted;
	}
	public void setDoctor_consulted(String doctor_consulted) {
		this.doctor_consulted = doctor_consulted;
	}
	public String getBody_temperature() {
		return body_temperature;
	}
	public void setBody_temperature(String body_temperature) {
		this.body_temperature = body_temperature;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
    
    
    
}
