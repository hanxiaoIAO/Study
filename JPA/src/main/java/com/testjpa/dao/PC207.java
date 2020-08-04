package com.testjpa.dao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="ehr_pypc207")
public class PC207 {

	@Id
	private Long oid;
	
	private Long soid;
	
	private Long pc205asign;
	
	@OneToOne
	@JoinColumn(name="wageitemid",referencedColumnName="oid")
	private WageItem wageitem;
	
	private BigDecimal amt;
	
	private BigDecimal num;
	
	private BigDecimal rte;
	
	public Long getPc205asign() {
		return pc205asign;
	}

	public void setPc205asign(Long pc205asign) {
		this.pc205asign = pc205asign;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public BigDecimal getRte() {
		return rte;
	}

	public void setRte(BigDecimal rte) {
		this.rte = rte;
	}

	public WageItem getWageitem() {
		return wageitem;
	}

	public void setWageitem(WageItem wageitem) {
		this.wageitem = wageitem;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getSoid() {
		return soid;
	}

	public void setSoid(Long soid) {
		this.soid = soid;
	}
}
