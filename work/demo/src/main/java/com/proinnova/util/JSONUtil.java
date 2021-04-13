package com.proinnova.util;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.proinnova.entity.UserEntity;

//import net.sf.json.JSONObject;

public class JSONUtil {
	public static void main(String args[]) throws Throwable {
		System.out.println("transferMap2JSON");
		Map<String, String> map = new HashMap<String ,String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		
		System.out.println(transferMap2JSON(map).toJSONString());
		
		System.out.println("transferEntity2JSON");
		UserEntity userEntity = new UserEntity();
		userEntity.setCode("Code");
		userEntity.setName("name");
		System.out.println(transferEntity2JSON(userEntity).toJSONString());
	}
	
	//JSON 的各种转换
	//1. Map 转 JSON
	public static JSONObject transferMap2JSON(Map<String, String> map) throws Throwable {
		JsonMapper mapper = new JsonMapper();
		String jsonStr = mapper.writeValueAsString(map);
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		return jsonObject;
	}
	
	//2. Entity 转 JSON
	public static JSONObject transferEntity2JSON(UserEntity user) throws Throwable {
		JsonMapper mapper = new JsonMapper();
		String jsonStr = mapper.writeValueAsString(user);
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
//		JSONObject.toJSON(javaObject)
		return jsonObject;
	}

}
