package hanxiao.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpTest {

	@Test
	public void testAddUser() {
		String configLocation = "/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.addUser();
		
		UserModel userModelFromFactory = (UserModel) applicationContext.getBean("userModelFromFactory");
		applicationContext.getBean("userServiceFromFactory");
		System.out.println(userModelFromFactory.getId());
		applicationContext.close();
	}
	
	@Test
	public void testRole() {
		String configLocation = "applicationContext_Annotation.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		Role role = (Role)applicationContext.getBean("role");
		System.out.println(role.getName());
		List<UserModel> userModelList = role.getUserModelList();
		for(UserModel userModel:userModelList) {
			System.out.println(userModel.getName());
		}
		applicationContext.close();
	}
	
	@Test
	public void testAOP() {
		String configLocation = "applicationContext_AOP.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		UserServiceImp userService = (UserServiceImp) applicationContext.getBean("userService");
		userService.toString();
		applicationContext.close();
	}
	
	@Test
	public void testAspectJ() {
		String configLocation = "applicationContext_Aspectj.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		UserServiceImp userService = (UserServiceImp) applicationContext.getBean("userService");
		userService.toString();
		applicationContext.close();
	}
	
	@Test
	public void testDao() {
		String configLocation = "applicationContext_Dao.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		UserDaoImp userDao = (UserDaoImp) applicationContext.getBean("useDao");
		userDao.printUser();
		applicationContext.close();
	}
}
