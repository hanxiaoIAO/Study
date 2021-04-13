package com.proinnova.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proinnova.dao.UserMapper;
import com.proinnova.entity.UserEntity;
import com.proinnova.util.BussinessLock;
import com.proinnova.util.BussinessLockFactory;

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BussinessLockFactory bussinessLockFactory;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/postHello")
	public String postHello() {
		System.out.println("hello");
		return "hello";
	}
	
	@PostMapping("/updateUserName")
	public String updateUserName(@RequestBody String name) {
		BussinessLock lock = bussinessLockFactory.getLock("user");
		if(lock.lock("1")) {
			while(true);
		}
		return "更新失败";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestBody String id) {
		BussinessLock lock = bussinessLockFactory.getLock("user");
		if(lock.lock(id)) {
			while(true);
		}
		return "删除失败";
	}
	
	@PostMapping("/unlock")
	public String unlock(@RequestBody String id) {
		BussinessLock lock = bussinessLockFactory.getLock("user");
		if(lock.unlock(id)) {
			return "解锁成功";
		}
		return "解锁失败";
	}
	
	@PostMapping("/batchUpdateUserName")
	public String batchUpdateUserName(@RequestBody String name) {
		BussinessLock lock = bussinessLockFactory.getLock("user");
		if(lock.lock("1")) {
			while(true);
		}
		return "更新失败";
	}
	
	@PostMapping("/saveUsers")
	public void saveUsers(@RequestBody List<UserEntity> userEntitys) {
		
		for(int i=0;i<50;i++) {
			UserEntity userEntity = new UserEntity();
			int j = 1000+i;
			userEntity.setCode(j+"");
			userEntity.setName(j+"");
			userEntitys.add(userEntity);
		}
		
		for(UserEntity userEntity:userEntitys) {
			userMapper.saveUser(userEntity);
		}
	}
	
	@PostMapping("/test")
	public void test() {
		List<String> list = new ArrayList<String>();
//		list.add("aa");
//		list.add("bb");
		userMapper.updateStatus(list, 3);
	}

}
