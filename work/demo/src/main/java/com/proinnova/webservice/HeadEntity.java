package com.proinnova.webservice;

import java.util.List;

public class HeadEntity {
	
	private int id;
	
	private String code;
	
	private List<DtlEntity> dtls;

	public List<DtlEntity> getDtls() {
		return dtls;
	}

	public void setDtls(List<DtlEntity> dtls) {
		this.dtls = dtls;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
