package hanxiao.spring;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String toString() {
		return "UserServiceImp [userDao]";
	}

	@Override
	public void addUser() {
		this.userDao.addUser();
	}
	
	public void init() {
		System.out.println("初始化");
	}
	public void destory() {
		System.out.println("銷毀");
	}
}
