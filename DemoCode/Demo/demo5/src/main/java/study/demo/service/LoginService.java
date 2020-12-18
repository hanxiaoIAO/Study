package study.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.demo.dao.RoleRepo;
import study.demo.dao.UserEntity;
import study.demo.dao.UserRepo;

@Service
public class LoginService {
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	UserRepo userPepo;
	
	public void regist(UserEntity user) {
		userPepo.save(user);
	}
	
	public void deRegist(String code) {
		Optional<UserEntity> user = userPepo.findByCode(code);
		if(user.isPresent()) {
			userPepo.delete(user.get());
		}
	}

}
