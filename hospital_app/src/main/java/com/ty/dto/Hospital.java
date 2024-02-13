package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	
		@Id
	    private String hospitalId;
	    private String hospitalName;
	    private String hospitalType;
	    private String accreditation;
	    private int foundingYear;
	    
	    @OneToMany
	    private List<Branch> branches;

		public String getHospitalId() {
			return hospitalId;
		}

		public void setHospitalId(String hospitalId) {
			this.hospitalId = hospitalId;
		}

		public String getHospitalName() {
			return hospitalName;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}

		public String getHospitalType() {
			return hospitalType;
		}

		public void setHospitalType(String hospitalType) {
			this.hospitalType = hospitalType;
		}

		public String getAccreditation() {
			return accreditation;
		}

		public void setAccreditation(String accreditation) {
			this.accreditation = accreditation;
		}

		public int getFoundingYear() {
			return foundingYear;
		}

		public void setFoundingYear(int foundingYear) {
			this.foundingYear = foundingYear;
		}

		public List<Branch> getBranches() {
			return branches;
		}

		public void setBranches(List<Branch> branches) {
			this.branches = branches;
		}
	    
	    
}
