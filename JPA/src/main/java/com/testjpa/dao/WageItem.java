package com.testjpa.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ehr_pywageitem")
public class WageItem {
	@Id
	private Long oid;

	private String code;
	private String usecode;
	private String name;
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsecode() {
		return usecode;
	}
	public void setUsecode(String usecode) {
		this.usecode = usecode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
