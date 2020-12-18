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

@Component
public class ApplicationRunnerImpl implements ApplicationRunner{

	@Autowired
	public UserRepo userDao;
	@Autowired
	public RoleRepo roleDao;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Optional<RoleEntity> roleOpt = roleDao.findByCode("Admin");
		if(!roleOpt.isPresent()) {
			RoleEntity role = new RoleEntity();
			role.setCode("Admin");
			role.setName("管理员");
			
			roleDao.save(role);
		}
		
		Optional<UserEntity> userOpt = userDao.findByCode("Administrator");
		if(!userOpt.isPresent()) {
			UserEntity user = new UserEntity();
			user.setCode("Administrator");
			user.setName("管理员");
			
			roleOpt = roleDao.findByCode("Admin");
			user.setRole(roleOpt.get());
			
			userDao.save(user);
		}
		
	}

}
