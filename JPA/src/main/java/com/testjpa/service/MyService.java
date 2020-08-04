package com.testjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testjpa.dao.WageResultEntity;
import com.testjpa.dao.WageResultResposition;

@Service
public class MyService {
	@Autowired
	WageResultResposition wageResultResposition;
	
	public List<WageResultEntity> findWageResult() {
		List<WageResultEntity> wageResultList = wageResultResposition.findAll();
		return wageResultList;
	}

}
