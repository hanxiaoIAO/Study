package com.proinnova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proinnova.event.PrintEvent;

@RestController
public class TestEventController {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@GetMapping("/printEvent")
	public String printEvent() throws Throwable {
		PrintEvent event = new PrintEvent("aaa");
		System.out.println("Event:"+Thread.currentThread());
		applicationContext.publishEvent(event);
		System.out.println("success");
		return "success";
	}

}
