package com.proinnova.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.proinnova.entity.UserEntity;

public interface UserMapper {
	
	public int createUserTable();
	
	public int saveUsers(List<UserEntity> userEntitys);
	
	@Insert("insert into user_entity (code,name) values (#{code},#{name})")
	public int saveUser(UserEntity userEntity);
	
	public UserEntity getUserById(Integer id);
	
	void updateStatus(@Param("cfIds")List<String> cfIds, @Param("status")Integer status);
	
}
