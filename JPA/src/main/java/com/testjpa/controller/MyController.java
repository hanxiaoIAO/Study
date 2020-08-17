package com.testjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testjpa.dao.WageResultEntity;
import com.testjpa.service.MyService;

@Controller
public class MyController {
	@Autowired
	MyService myService;

	@RequestMapping(path = "/findResult",method = {RequestMethod.GET,RequestMethod.POST}) 
	@ResponseBody
	public String findResult() {
		List<WageResultEntity> wageResultList = myService.findWageResult();
		for(WageResultEntity wageResult:wageResultList) {
			System.out.println(wageResult.getOid());
		}
		return "hello";
	}
	
	@RequestMapping("/index") 
	public String index() {
		return "index";
	}
	
}
