package com.proinnova.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BussinessLockFactory {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	static Map<String,BussinessLock> lockList = new HashMap<>();
	
	public BussinessLock getLock(String bussinessType) {
		if(lockList.containsKey(bussinessType)) {
			return lockList.get(bussinessType);
		}else {
			BussinessLock lock = new BussinessLock(jdbcTemplate,bussinessType);
			lockList.put(bussinessType, lock);
			return lock;
		}
	}

}
