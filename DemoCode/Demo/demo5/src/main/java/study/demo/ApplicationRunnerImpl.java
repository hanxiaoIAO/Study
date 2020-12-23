package study.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import study.demo.dao.RoleEntity;
import study.demo.dao.RoleRepo;
import study.demo.dao.UserEntity;
import study.demo.dao.UserRepo;
import study.demo.service.PasswordService;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner{

	@Autowired
	public UserRepo userDao;
	@Autowired
	public RoleRepo roleDao;
	
	@Autowired
	public PasswordService passwordService;
	
	
	@Override
	public void run(ApplicationArguments args) {
		Optional<RoleEntity> roleOpt = roleDao.findByCode("Admin");
		if(!roleOpt.isPresent()) {
			RoleEntity role = new RoleEntity();
			role.setCode("Admin");
			role.setName("管理员");
			
			roleDao.save(role);
		}
		
		roleOpt = roleDao.findByCode("Guest");
		if(!roleOpt.isPresent()) {
			RoleEntity role = new RoleEntity();
			role.setCode("Guest");
			role.setName("游客");
			
			roleDao.save(role);
		}
		
		Optional<UserEntity> userOpt = userDao.findByCode("Administrator");
		if(!userOpt.isPresent()) {
			UserEntity user = new UserEntity();
			user.setCode("Administrator");
			user.setName("管理员");
			
			user.setPassword(passwordService.encrypt("123456"));
			
			roleOpt = roleDao.findByCode("Admin");
			user.setRole(roleOpt.get());
			
			userDao.save(user);
		}
		
		userOpt = userDao.findByCode("Guest");
		if(!userOpt.isPresent()) {
			UserEntity user = new UserEntity();
			user.setCode("Guest");
			user.setName("游客");
			
			user.setPassword(passwordService.encrypt(""));
			
			roleOpt = roleDao.findByCode("Guest");
			user.setRole(roleOpt.get());
			
			userDao.save(user);
		}
		
	}

}
