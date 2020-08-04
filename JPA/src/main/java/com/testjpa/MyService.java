//package com.testjpa;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class MyService {
//	
//	@Autowired
//	MyResposition myResoisition;
//	
//	@RequestMapping(path = "/testJpa",method = {RequestMethod.GET,RequestMethod.POST}) 
//	public String testJpa() {
//		List<StudentEntity> studentList = myResoisition.findAll();
//		for(StudentEntity student:studentList) {
//			System.out.println(student.getName());	
//		}
//		
////		StudentEntity cc = new StudentEntity();
////		cc.setId(3);
////		cc.setName("cc");
////		myResoisition.save(cc);
//		
//		return "testJPA";
//	}
//
//}
