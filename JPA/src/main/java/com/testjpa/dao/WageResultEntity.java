package com.testjpa.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="ehr_pywageresult")
public class WageResultEntity {
	@Id
	private Long oid;
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	@OneToMany(mappedBy="soid")
	private List<PC207> pc207List;

	public List<PC207> getPc207List() {
		return pc207List;
	}

	public void setPc207List(List<PC207> pc207List) {
		this.pc207List = pc207List;
	}

	
	
	
}
