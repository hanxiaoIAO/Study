package com.proinnova.util;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BussinessLock {
	
	JdbcTemplate jdbcTemplate;
	
	String bussinessType;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	BussinessLock(JdbcTemplate jdbcTemplate,String bussinessType){
		this.bussinessType = bussinessType;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean lock(String cuId) {
		boolean flag = true;
		try {
			jdbcTemplate.update("INSERT INTO bussiness_lock (update_time,bussiness_id, message, bussiness_type) VALUES(?, ?, ?, ?)", LocalDateTime.now(),cuId,"加锁",bussinessType);
		} catch(Exception e) {
			logger.info(e.getMessage());
			flag = false;
		}
		
		return flag;
	}
	
	public boolean unlock(String cuId) {
		boolean flag = true;
		try {
			jdbcTemplate.update("delete from bussiness_lock where bussiness_id=? and bussiness_type = ?",cuId,bussinessType);
		} catch(Exception e) {
			logger.info(e.getMessage());
			flag = false;
		}
		
		return flag;
	}
	
	public boolean lockTable() {
		boolean flag = true;
		try {
			jdbcTemplate.execute("lock bussiness_lock");
		} catch(Exception e) {
			logger.info(e.getMessage());
			flag = false;
		}
		
		return flag;
	}
	
	public boolean unlockTable() {
		boolean flag = true;
		try {
			jdbcTemplate.execute("");
		} catch(Exception e) {
			logger.info(e.getMessage());
			flag = false;
		}
		
		return flag;
	}

}
